package com.alvaro.demo.heroes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.response.FindAllResponse;

@RestController
public class FindAllController {
	
	/**
	 * Se obtienen todos los heroes
	 * @return FindAllResponse
	 */
	@GetMapping(value = "heroes/findAll")
	public FindAllResponse findAll() {
		return null;
	}

}
