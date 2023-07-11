package com.magdiel.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magdiel.curso.entities.User;

@RestController
@RequestMapping(value="users")
public class usaerResources {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L,"Magdiel", "santosmagdeil931@gmail.com","41 985049653","mago9666");
		return ResponseEntity.ok().body(user);
	}
}
