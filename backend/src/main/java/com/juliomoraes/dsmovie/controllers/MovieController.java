package com.juliomoraes.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.dsmovie.dto.MovieDTO;
import com.juliomoraes.dsmovie.services.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private IMovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll(pageable));
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long movieId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.findById(movieId));
	}

}
