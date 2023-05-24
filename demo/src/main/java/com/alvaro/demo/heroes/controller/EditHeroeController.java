package com.alvaro.demo.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.demo.heroes.dto.request.EditHeroeRequest;
import com.alvaro.demo.heroes.dto.response.EditHeroeResponse;
import com.alvaro.demo.heroes.model.Heroe;
import com.alvaro.demo.heroes.service.HeroeService;

@RestController
public class EditHeroeController {
	
	
	@Autowired
	private HeroeService heroeService;
	
	/**
	 * Se edita un heroe, si existe su id.
	 * @param request
	 * @return
	 * @throws CustomException
	 * @throws RestTemplateException
	 */
	@PostMapping(value = "heroes/editHeroe")
	public EditHeroeResponse editHeroe(@RequestBody EditHeroeRequest request) {
		Heroe heroe = heroeService.editHeroe(request);
		String result = (heroe == null 
				? "No existe el id" 
				: "Heroe editado correctamente!");
		return EditHeroeResponse.builder()
				.result(result)
				.heroe(heroe)
				.build();
	}

}
