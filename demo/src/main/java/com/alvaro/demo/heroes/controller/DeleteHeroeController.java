package com.alvaro.demo.heroes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.response.HeroeResponse;

@RestController
public class DeleteHeroeController {
	
	
	/**
	 * Se borra un hero del sistema, si existe su id
	 * @param request
	 * @return
	 * @throws CustomException
	 * @throws RestTemplateException
	 */
	@GetMapping(value = "heroes/deleteHeroe")
	public HeroeResponse deleteHeroe(@RequestParam(required=true) String id) {
		return null;
	}

}
