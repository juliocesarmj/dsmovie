package com.juliomoraes.dsmovie.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juliomoraes.dsmovie.dto.MovieDTO;
import com.juliomoraes.dsmovie.dto.ScoreDTO;
import com.juliomoraes.dsmovie.entities.Movie;
import com.juliomoraes.dsmovie.entities.Score;
import com.juliomoraes.dsmovie.entities.User;
import com.juliomoraes.dsmovie.repositories.IMovieRepository;
import com.juliomoraes.dsmovie.repositories.IScoreRepository;
import com.juliomoraes.dsmovie.repositories.IUserRepository;

@Service
public class ScoreService implements IScoreService {

	@Autowired
	private IScoreRepository scoreRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IMovieRepository movieRepository;

	@Override
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = this.userRepository.findByEmail(dto.getEmail());

		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			this.userRepository.saveAndFlush(user);
		}

		Movie movie = this.movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();

		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		this.scoreRepository.saveAndFlush(score);

		double sum = 0.0;

		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}

		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		this.movieRepository.save(movie);

		return new MovieDTO(movie);
	}

}
