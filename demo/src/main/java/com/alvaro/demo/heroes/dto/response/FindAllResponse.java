package com.alvaro.demo.heroes.dto.response;

import java.util.List;

import com.alvaro.demo.heroes.model.Heroe;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
public class FindAllResponse extends HeroeResponse{
	
	List<Heroe> heroes;

}
