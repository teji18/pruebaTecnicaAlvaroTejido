package com.alvaro.demo.heroes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BD_HEROES")
public class Heroe {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	
	String name;
	String superpower;
	String city;
}
