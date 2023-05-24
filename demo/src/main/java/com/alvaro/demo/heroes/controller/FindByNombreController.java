package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.response.FindByNombreResponse;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class FindByNombreController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se obtiene el heroe que se llame como el nombre
	 * @param nombre
	 * @return FindByNombreResponse
	 */
	@GetMapping(value = "heroes/findByNombre")
	public FindByNombreResponse findByNombre(@RequestParam(required = true) String nombre) {
		return FindByNombreResponse.builder()
				.heroe(heroeService.findHeroeByNombre(nombre))
				.result("OK")
				.build();
	}

}
