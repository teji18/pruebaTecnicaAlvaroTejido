package com.alvaro.demo.heroes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alvaro.demo.heroes.model.Heroe;

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Integer>{

	/**
	 * Método que devuelve un heroe que se llame como el parametro en estado Optional
	 * @param name
	 * @return Optional<Heroe>
	 */
	Optional<Heroe> findByName(String name);
	
	/**
	 * Método que devuelve la lista de heroes que encajan con
	 * el trozo de texto que se pasa por parametro.
	 * @param name
	 * @return
	 */
	@Query("FROM Heroe heroe WHERE UPPER(heroe.name) LIKE %:name%")
	List<Heroe> findByNameLike(String name);

}
