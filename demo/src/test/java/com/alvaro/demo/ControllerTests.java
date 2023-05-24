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
import com.alvaro.demo.heroes.controller.FindByNameController;
import com.alvaro.demo.heroes.controller.FindByNameLikeController;
import com.alvaro.demo.heroes.dto.request.AddHeroeRequest;
import com.alvaro.demo.heroes.dto.response.FindAllResponse;
import com.alvaro.demo.heroes.model.Heroe;
import com.alvaro.demo.heroes.repository.HeroeRepository;

@SpringBootTest(classes = {DemoApplication.class})
public class ControllerTests {
	
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
	FindByNameController findBynameController;
	
	@Autowired
	FindByNameLikeController findBynameLikeController;
	
	@Test
	void testAddHeroe() {
		String city = "Gotham";
		String name = "Batman";
		String superpower = "Dinero ilimitado";
		
		AddHeroeRequest request = AddHeroeRequest.builder()
				.city(city)
				.name(name)
				.superpower(superpower)
				.build();
		
		int numHeroesPre = heroesRepo.findAll().size();
		
		addController.addHeroe(request);

		int numHeroesPost = heroesRepo.findAll().size();
		
		assertEquals(numHeroesPre, numHeroesPost-1);
	}
	
	@Test
	void testDeleteHeroe() {
		Heroe heroe = Heroe.builder()
				.name("Capitán Trueno")
				.city("Murcia")
				.superpower("España")
				.build();
		
		heroesRepo.save(heroe);
		
		int numHeroesPre = heroesRepo.findAll().size();
		
		deleteController.deleteHeroe(heroe.getId());

		int numHeroesPost = heroesRepo.findAll().size();
		
		assertEquals(numHeroesPre, numHeroesPost+1);
	}
	
	@Test
	void testFindAll() {
		for(int i=0; i<3;i++) {
			Heroe heroe = Heroe.builder()
					.city("New York_"+i)
					.name("SuperHeroe_"+i)
					.superpower("superpower_"+i)
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
	void testFindBynameLike() {
		Heroe heroe = Heroe.builder()
				.city("EEUU")
				.name("Antorcha Humana")
				.superpower("Fuego")
				.build();
		
		Heroe heroe2 = Heroe.builder()
				.city("Oregon")
				.name("Hulk")
				.superpower("Fuerza")
				.build();
		
		heroesRepo.save(heroe);
		heroesRepo.save(heroe2);
		
		String name = "hu";
		
		int numHeroes = findBynameLikeController.findByNameLike(name)
				.getHeroes().size();
		assertEquals(2, numHeroes);
	}
	
	@Test
	void testFindByname() {
		String name = "TEST_name";
		
		Heroe heroe = Heroe.builder()
				.name(name)
				.city(null)
				.superpower(null)
				.build();
		
		Optional<Heroe> resultPre = heroesRepo.findByName(name);
		
		assertTrue(resultPre.isEmpty());
		
		heroesRepo.save(heroe);
		
		Optional<Heroe> resultPost = heroesRepo.findByName(name);
		
		assertEquals(name, resultPost.get().getName());
	}
}
