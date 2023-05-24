package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.annotation.TimeAnnotation;
import com.alvaro.demo.heroes.dto.response.FindByNameLikeResponse;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class FindByNameLikeController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se obtienen los heroes que contengan el String nombre
	 * @param name
	 * @return FindByNameLikeResponse
	 */
	@GetMapping(value = "/heroes/findByNameLike")
	@TimeAnnotation
	public FindByNameLikeResponse findByNameLike(@RequestParam(required = true) String name) {
		return FindByNameLikeResponse.builder()
				.heroes(heroeService.findHeroeByNameLike(name))
				.result("OK")
				.build();
	}

}
