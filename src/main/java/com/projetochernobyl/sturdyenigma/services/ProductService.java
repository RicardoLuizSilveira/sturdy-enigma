package com.projetochernobyl.sturdyenigma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.domain.Product;
import com.projetochernobyl.sturdyenigma.repository.CategoryRepository;
import com.projetochernobyl.sturdyenigma.repository.ProductRepository;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository rep;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Product findById(Long id) {
		Optional<Product> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("SIC-7", "Order not found. Id: " + id));
	}
	
	public Page<Product> seach(String name, List<Long> ids, Integer pageNumber, Integer linesPerPage, String direction, String orderBy){
		Pageable pageRequest = PageRequest.of(pageNumber, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categories = categoryRepository.findAllById(ids);
		//return rep.search(name, categories, pageRequest);
		return rep.findDistinctByNameIgnoreCaseContainingAndCategoriesIn(name, categories, pageRequest);
	}
	
}
