package com.magdiel.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magdiel.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
