package com.alvaro.demo.heroes.dto.request;

import lombok.Data;

@Data
public class EditHeroeRequest {

	int id;
	String name;
	String city;
	String superpower;
}
