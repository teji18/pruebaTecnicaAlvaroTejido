package com.alvaro.demo.heroes.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.request.EditHeroeRequest;
import com.alvaro.demo.heroes.dto.response.EditHeroeResponse;

@RestController
public class EditHeroeController {
	
	/**
	 * Se edita un heroe, si existe su id.
	 * @param request
	 * @return
	 * @throws CustomException
	 * @throws RestTemplateException
	 */
	@PostMapping(value = "heroes/editHeroe")
	public EditHeroeResponse editHeroe(@RequestBody EditHeroeRequest request) {
		return null;
	}

}
