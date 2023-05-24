package com.alvaro.demo.heroes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alvaro.demo.heroes.model.Heroe;

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Integer>{

	Optional<Heroe> findByName(String name);
	
	@Query("FROM Heroe heroe WHERE UPPER(heroe.name) LIKE %:name%")
	List<Heroe> findByNameLike(String name);

}
