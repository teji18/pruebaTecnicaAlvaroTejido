package com.alvaro.demo.heroes.annotation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/heroes/*")
public class TimingFilter implements Filter{

	/**
	 * Método que nos permite medir el tiempo total que tarda
	 * una petición en realizarse. Se aplicará a todos aquellos
	 * métodos que sean anotados con @TimeAnnotation.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request,  response);
		
		String name = ((HttpServletRequest) request).getRequestURI();
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime-startTime;
		
		System.out.println("Duración de la petición '" + name + "' -> " + totalTime + " ms.");
	}

}
