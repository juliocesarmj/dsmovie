package com.juliomoraes.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliomoraes.dsmovie.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
