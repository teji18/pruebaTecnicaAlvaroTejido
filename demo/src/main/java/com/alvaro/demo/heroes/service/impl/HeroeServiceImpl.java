package com.alvaro.demo.heroes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaro.demo.heroes.dto.request.AddHeroeRequest;
import com.alvaro.demo.heroes.dto.request.EditHeroeRequest;
import com.alvaro.demo.heroes.model.Heroe;
import com.alvaro.demo.heroes.repository.HeroeRepository;
import com.alvaro.demo.heroes.service.HeroeService;

@Service
public class HeroeServiceImpl implements HeroeService {
	
	@Autowired
	HeroeRepository heroeRepository;

	/**
	 * Método que crea una entidad Heroe y la guarda en su repositorio.
	 * 
	 * @param HeroRequest request
	 */
	@Override
	public void addHeroe(AddHeroeRequest request) {
		Heroe heroe = Heroe.builder()
				.name(!request.getName().isEmpty() ? request.getName() : null)
				.city(!request.getCity().isEmpty() ? request.getCity() : null)
				.superpower(!request.getSuperpower().isEmpty() ? request.getSuperpower() : null)
				.build();
		
		heroeRepository.saveAndFlush(heroe);
	}

	/**
	 * Método que devuelve el heroe con el nombre indicado, o null si no existe.
	 * 
	 * @param String nombre
	 * @return los heroes específicos
	 */
	@Override
	public Heroe findHeroeByName(String nombre) {
		Optional<Heroe> heroe = heroeRepository.findByName(nombre);
		return heroe.isPresent() ? heroe.get() : null;
	}

	/**
	 * Método que devuelve todos los heroes del sistema
	 * 
	 * @return todos los heroes.
	 */
	@Override
	public List<Heroe> findAllHeroes() {
		return heroeRepository.findAll();
	}

	/**
	 * Método que devuelve una lista de heroes que contengan en su nombre
	 * el String que se pasa por parametro.
	 * 
	 * @param String nombre
	 * @return los heroes específicos
	 */
	@Override
	public List<Heroe> findHeroeByNameLike(String nombre) {
		return heroeRepository.findByNameLike(nombre.toUpperCase());
	}

	/**
	 * Método que borra de la base de datos el heroe con el id igual
	 * al parametro que se pasa.
	 * 
	 * @param int id
	 * @return String que representa el resultado de la acción
	 */
	@Override
	public String deleteHeroe(int id) {
		Optional<Heroe> optHeroe = heroeRepository.findById(id);
		if(optHeroe.isPresent()) {
			Heroe heroe = optHeroe.get();
			
			heroeRepository.delete(heroe);
			return "Heroe borrado correctamente!";
		} else {
			return "El ID no se corresponde con ningún heroe";
		}
	}

	/**
	 * Método que devuelve el heroe con el id indicado, o null si no existe.
	 * 
	 * @param String nombre
	 * @return el heroe específico 
	 */
	@Override
	public Heroe findHeroeById(int id) {
		Optional<Heroe> heroe = heroeRepository.findById(id);
		return heroe.isPresent() ? heroe.get() : null;
	}

	/**
	 * Método que permite sobreescribir los datos de un heroe.
	 * 
	 * @param HeroeRequest request
	 * @return String que representa el resultado de la acción
	 */
	@Override
	public Heroe editHeroe(EditHeroeRequest request) {
		Optional<Heroe> optHeroe = heroeRepository.findById(request.getId());
		if(optHeroe.isPresent()) {
			Heroe heroe = optHeroe.get();
			if(!request.getName().isEmpty())
				heroe.setName(request.getName());
			if(!request.getCity().isEmpty())
				heroe.setCity(request.getCity());
			if(!request.getSuperpower().isEmpty())
				heroe.setSuperpower(request.getSuperpower());
			
			heroeRepository.saveAndFlush(heroe);
			return heroe;
		} else {
			return null;
		}
	}

}
