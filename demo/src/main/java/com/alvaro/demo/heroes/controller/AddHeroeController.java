package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.annotation.TimeAnnotation;
import com.alvaro.demo.heroes.dto.request.AddHeroeRequest;
import com.alvaro.demo.heroes.dto.response.HeroeResponse;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class AddHeroeController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se añade un heroe al sistema
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/heroes/addHeroe")
	@TimeAnnotation
	public HeroeResponse addHeroe(@RequestBody AddHeroeRequest request) {
		heroeService.addHeroe(request);
		return HeroeResponse.builder()
				.result("El heroe ha sido añadido correctamente!")
				.build();
	}

}
