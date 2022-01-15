package com.brito.movie.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brito.movie.dto.MovieDTO;
import com.brito.movie.entities.Movie;
import com.brito.movie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> listarTodas(Pageable pageable){
		Page<Movie> movies = movieRepository.findAll(pageable);
		Page<MovieDTO> page = movies.map(x -> new MovieDTO(x));
		
		return page;
		
	}
	
	@Transactional(readOnly = true)
	public MovieDTO listarPorId(Long id){
		Movie movie = movieRepository.findById(id).get();
		MovieDTO dto = new MovieDTO(movie);
		
		return dto;
		
	}
}
