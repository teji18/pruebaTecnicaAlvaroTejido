package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.response.FindAllResponse;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class FindAllController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se obtienen todos los heroes
	 * @return FindAllResponse
	 */
	@GetMapping(value = "heroes/findAll")
	public FindAllResponse findAll() {
		return FindAllResponse.builder()
				.heroes(heroeService.findAllHeroes())
				.result("OK")
				.build();
	}

}
