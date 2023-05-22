package com.alvaro.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alvaro.demo.heroes.controller.AddHeroeController;
import com.alvaro.demo.heroes.controller.DeleteHeroeController;
import com.alvaro.demo.heroes.controller.EditHeroeController;
import com.alvaro.demo.heroes.controller.FindAllController;
import com.alvaro.demo.heroes.controller.FindByNombreController;
import com.alvaro.demo.heroes.controller.FindByNombreLikeController;
import com.alvaro.demo.heroes.dto.request.AddHeroeRequest;
import com.alvaro.demo.heroes.dto.response.FindAllResponse;
import com.alvaro.demo.heroes.model.Heroe;
import com.alvaro.demo.heroes.repository.HeroeRepository;

@SpringBootTest(classes = {DemoApplication.class})
public class TestControladores {
	
	@Autowired
	HeroeRepository heroesRepo;
	
	@Autowired
	AddHeroeController addController;
	
	@Autowired
	DeleteHeroeController deleteController;
	
	@Autowired
	EditHeroeController editController;
	
	@Autowired
	FindAllController findAllController;
	
	@Autowired
	FindByNombreController findByNombreController;
	
	@Autowired
	FindByNombreLikeController findByNombreLikeController;
	
	@Test
	void testAddHeroe() {
		String ciudad = "Gotham";
		String nombre = "Batman";
		String superpoder = "Dinero ilimitado";
		
		AddHeroeRequest request = AddHeroeRequest.builder()
				.ciudad(ciudad)
				.nombre(nombre)
				.superpoder(superpoder)
				.build();
		
		int numHeroesPre = heroesRepo.findAll().size();
		
		addController.addHeroe(request);

		int numHeroesPost = heroesRepo.findAll().size();
		
		assertEquals(numHeroesPre, numHeroesPost-1);
	}
	
	@Test
	void testDeleteHeroe() {
		int numHeroesPre = heroesRepo.findAll().size();
		
		deleteController.deleteHeroe("1");

		int numHeroesPost = heroesRepo.findAll().size();
		
		assertEquals(numHeroesPre, numHeroesPost+1);
	}
	
	@Test
	void testFindAll() {
		for(int i=0; i<3;i++) {
			Heroe heroe = Heroe.builder()
					.ciudad("New York_"+i)
					.nombre("SuperHeroe_"+i)
					.superpoder("superpoder_"+i)
					.build();
			
			heroesRepo.save(heroe);
		}
		
		List<Heroe> lista = heroesRepo.findAll();
		
		FindAllResponse response = FindAllResponse.builder()
				.heroes(lista)
				.result("OK")
				.build();
		
		FindAllResponse resultPost = findAllController.findAll();
		assertEquals(response , resultPost);
	}
	
	@Test
	void testFindByNombreLike() {
		
		Heroe heroe = Heroe.builder()
				.ciudad("EEUU")
				.nombre("Antorcha Humana")
				.superpoder("Fuego")
				.build();
		
		Heroe heroe2 = Heroe.builder()
				.ciudad("Oregon")
				.nombre("Hulk")
				.superpoder("Fuerza")
				.build();
		
		heroesRepo.save(heroe);
		heroesRepo.save(heroe2);
		
		String nombre = "hu";
		
		int numHeroes = findByNombreLikeController.findByNombreLike(nombre)
				.getHeroes().size();
		assertEquals(2, numHeroes);
	}
	
	@Test
	void testFindByNombre() {
		String nombre = "TEST_NOMBRE";
		
		Heroe heroe = Heroe.builder()
				.nombre(nombre)
				.ciudad(null)
				.superpoder(null)
				.build();
		
		Optional<Heroe> resultPre = heroesRepo.findByNombre(nombre);
		
		assertTrue(resultPre.isEmpty());
		
		heroesRepo.save(heroe);
		
		Optional<Heroe> resultPost = heroesRepo.findByNombre(nombre);
		
		assertEquals(nombre, resultPost.get().getNombre());
	}
}
