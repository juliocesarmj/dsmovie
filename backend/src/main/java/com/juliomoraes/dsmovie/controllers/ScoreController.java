package com.juliomoraes.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.dsmovie.dto.MovieDTO;
import com.juliomoraes.dsmovie.dto.ScoreDTO;
import com.juliomoraes.dsmovie.services.IScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	@Autowired
	private IScoreService scoreService;
	
	@PutMapping
	public ResponseEntity<MovieDTO> saveScore(@RequestBody ScoreDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(this.scoreService.saveScore(dto));
	}

}
