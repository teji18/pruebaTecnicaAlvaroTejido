package com.alvaro.demo.heroes.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alvaro.demo.heroes.dto.response.HeroeResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<HeroeResponse> processErrorResponse(Exception e) {

    	String mensaje = e.getMessage();

    	log.error("Ha ocurrido un error [{} - {}]", e.getClass().getSimpleName(), mensaje);
    	
    	HeroeResponse response = HeroeResponse.builder()
    			.result(mensaje)
    			.build();
    	return ResponseEntity.status(200).body(response);
	
    }
}
