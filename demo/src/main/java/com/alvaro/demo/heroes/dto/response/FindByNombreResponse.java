package com.alvaro.demo.heroes.dto.response;

import com.alvaro.demo.heroes.model.Heroe;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
public class FindByNombreResponse extends HeroeResponse{
	
	Heroe heroe;

}
