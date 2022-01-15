package com.juliomoraes.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juliomoraes.dsmovie.dto.MovieDTO;
import com.juliomoraes.dsmovie.repositories.IMovieRepository;

@Service
public class MovieService implements IMovieService {
	
	@Autowired
	private IMovieRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		return this.repository.findAll(pageable).map(MovieDTO::new);
	}

	@Override
	public MovieDTO findById(Long movieId) {
		return this.repository.findById(movieId).map(MovieDTO::new).get();
	}

}
