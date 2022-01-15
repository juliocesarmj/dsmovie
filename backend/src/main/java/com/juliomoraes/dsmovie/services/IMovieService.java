package com.juliomoraes.dsmovie.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juliomoraes.dsmovie.dto.MovieDTO;

public interface IMovieService {
	
	Page<MovieDTO> findAll(Pageable pageable);
	
	MovieDTO findById(Long movieId);
}
