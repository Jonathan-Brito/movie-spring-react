package com.brito.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brito.movie.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
