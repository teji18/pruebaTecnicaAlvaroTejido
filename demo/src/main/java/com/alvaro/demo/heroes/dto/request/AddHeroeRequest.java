package com.alvaro.demo.heroes.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddHeroeRequest{

	Long id;
	String name;
	String city;
	String superpower;
}
