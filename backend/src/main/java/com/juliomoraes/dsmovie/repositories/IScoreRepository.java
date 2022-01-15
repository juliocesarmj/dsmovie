package com.juliomoraes.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliomoraes.dsmovie.entities.Score;
import com.juliomoraes.dsmovie.entities.ScorePK;

public interface IScoreRepository extends JpaRepository<Score, ScorePK> {

}
