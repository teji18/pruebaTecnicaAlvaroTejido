package com.alvaro.demo.heroes.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddHeroeRequest{

	Long id;
	String nombre;
	String ciudad;
	String superpoder;
}
