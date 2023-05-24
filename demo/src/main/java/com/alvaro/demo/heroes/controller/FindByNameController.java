package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.annotation.TimeAnnotation;
import com.alvaro.demo.heroes.dto.response.FindByNameResponse;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class FindByNameController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se obtiene el heroe que se llame como el nombre
	 * @param name
	 * @return FindByNameResponse
	 */
	@GetMapping(value = "/heroes/findByName")
	@TimeAnnotation
	public FindByNameResponse findByName(@RequestParam(required = true) String name) {
		return FindByNameResponse.builder()
				.heroe(heroeService.findHeroeByName(name))
				.result("OK")
				.build();
	}

}
