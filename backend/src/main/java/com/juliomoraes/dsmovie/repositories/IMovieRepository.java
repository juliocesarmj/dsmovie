package com.juliomoraes.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliomoraes.dsmovie.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

}
