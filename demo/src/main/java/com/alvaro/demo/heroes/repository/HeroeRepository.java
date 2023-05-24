package com.alvaro.demo.heroes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alvaro.demo.heroes.model.Heroe;

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Integer>{

	Optional<Heroe> findByNombre(String nombre);
	
	@Query("FROM Heroe heroe WHERE UPPER(heroe.nombre) LIKE %:nombre%")
	List<Heroe> findByNombreLike(String nombre);

}
