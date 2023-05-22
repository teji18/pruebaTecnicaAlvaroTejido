package com.alvaro.demo.heroes.dto.request;

import lombok.Data;

@Data
public class EditHeroeRequest {

	int id;
	String nombre;
	String ciudad;
	String superpoder;
}
