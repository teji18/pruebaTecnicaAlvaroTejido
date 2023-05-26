package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.annotation.TimeAnnotation;
import com.alvaro.demo.heroes.dto.response.HeroeResponse;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class DeleteHeroeController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se borra un hero del sistema, si existe su id
	 * @param id
	 * @return HeroResponse
	 */
	@GetMapping(value = "/heroes/deleteHeroe")
	@TimeAnnotation
	public HeroeResponse deleteHeroe(@RequestParam(required=true) int id) {
		String result = heroeService.deleteHeroe(id);
		return HeroeResponse.builder()
				.result(result)
				.build();
	}

}
