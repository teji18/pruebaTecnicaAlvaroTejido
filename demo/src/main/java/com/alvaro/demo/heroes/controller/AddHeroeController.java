package com.alvaro.demo.heroes.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.request.AddHeroeRequest;
import com.alvaro.demo.heroes.dto.response.HeroeResponse;

@RestController
public class AddHeroeController {
	
	
	/**
	 * Se añade un heroe al sistema
	 * @param request
	 * @return
	 */
	@PostMapping(value = "heroes/addHeroe")
	public HeroeResponse addHeroe(@RequestBody AddHeroeRequest request) {
		return null;
	}

}
