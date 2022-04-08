package com.tiago.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.projetoSpring.entities.Category;
import com.tiago.projetoSpring.entities.dtos.CategoryDTO;
import com.tiago.projetoSpring.repositories.CategoryRepository;
import com.tiago.projetoSpring.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findAll() {
		return repository.findAll().stream().map(x -> new CategoryDTO(x)).toList();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: " + id));
	}
	
}
