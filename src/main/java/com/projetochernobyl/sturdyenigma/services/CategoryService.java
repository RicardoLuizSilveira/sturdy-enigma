package com.projetochernobyl.sturdyenigma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository rep;
	
	public Category findById(Long id) {
		Optional<Category> opt = rep.findById(id);
		return opt.orElse(null);
	}
	
	public List<Category> findAll() {
		return rep.findAll();
	}
	

}
