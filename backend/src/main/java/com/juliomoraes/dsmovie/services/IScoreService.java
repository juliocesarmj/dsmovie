package com.juliomoraes.dsmovie.services;

import com.juliomoraes.dsmovie.dto.MovieDTO;
import com.juliomoraes.dsmovie.dto.ScoreDTO;

public interface IScoreService {
	
	MovieDTO saveScore(ScoreDTO dto);
}
