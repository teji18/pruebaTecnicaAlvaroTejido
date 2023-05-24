package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.response.FindByNombreLikeResponse;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class FindByNombreLikeController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se obtienen los heroes que contengan el String nombre
	 * @param nombre
	 * @return FindByNombreLikeResponse
	 */
	@GetMapping(value = "heroes/findByNombreLike")
	public FindByNombreLikeResponse findByNombreLike(@RequestParam(required = true) String nombre) {
		return FindByNombreLikeResponse.builder()
				.heroes(heroeService.findHeroeByNombreLike(nombre))
				.result("OK")
				.build();
	}

}
