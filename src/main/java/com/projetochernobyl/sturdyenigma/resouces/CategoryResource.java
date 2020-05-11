package com.projetochernobyl.sturdyenigma.resouces;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetochernobyl.sturdyenigma.domain.Category;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryResource {
	
	@GetMapping
	public List<Category> list() {
		Category cat1 = new Category(1L, "Informática");
		Category cat2 = new Category(2L, "Escritório");
		return Arrays.asList(cat1, cat2);
	}
	
}
