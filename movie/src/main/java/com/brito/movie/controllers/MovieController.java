package com.brito.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brito.movie.dto.MovieDTO;
import com.brito.movie.servicies.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public Page<MovieDTO> listarTodas(Pageable pageable){
		return movieService.listarTodas(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public MovieDTO listarPorId(@PathVariable Long id){
		return movieService.listarPorId(id);
	}
}
