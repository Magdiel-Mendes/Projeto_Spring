package com.magdiel.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.magdiel.curso.entities.User;
import com.magdiel.curso.repositories.UserRepository;
import com.magdiel.curso.services.exception.DatabaseException;
import com.magdiel.curso.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public User update(Long id, User obj) {
				try {
					User entity = repository.getReferenceById(id);
					updateData(entity, obj);
					return repository.save(entity);
				}
			   catch (EntityNotFoundException e) {
					throw new ResourceNotFoundException(id);
				}	
			}
	
	private void updateData(User entity, User obj) {
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

	public void delete(Long id) {
		   try {
		        if (repository.existsById(id)) {
		            repository.deleteById(id);			
		        } else {				
		            throw new ResourceNotFoundException(id);			
		        }		
		    } catch (DataIntegrityViolationException e) {			
		        throw new DatabaseException(e.getMessage());		
		    } 	
		} 
}
