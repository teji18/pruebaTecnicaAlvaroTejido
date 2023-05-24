package com.alvaro.demo.heroes.service;

import java.util.List;

import com.alvaro.demo.heroes.dto.request.AddHeroeRequest;
import com.alvaro.demo.heroes.dto.request.EditHeroeRequest;
import com.alvaro.demo.heroes.model.Heroe;

public interface HeroeService {

	public void addHeroe(AddHeroeRequest request);
	
	public Heroe findHeroeByNombre(String nombre);
	
	public List<Heroe> findAllHeroes();

	public List<Heroe> findHeroeByNombreLike(String nombre);
	
	public Heroe findHeroeById(int id);

	public Heroe editHeroe(EditHeroeRequest request);

	public String deleteHeroe(int id);
}
