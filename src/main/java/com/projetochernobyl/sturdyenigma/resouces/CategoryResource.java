package com.projetochernobyl.sturdyenigma.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.resouces.responses.ResponseDTO;
import com.projetochernobyl.sturdyenigma.services.CategoryService;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<Category>>> findAll() {
		ResponseDTO<List<Category>> data = new ResponseDTO<>();
		data.setData(service.findAll());
		return ResponseEntity.ok(data);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<Category>> findById(@PathVariable(value = "id") Long id) {
		ResponseDTO<Category> data = new ResponseDTO<>();
		data.setData(service.findById(id));
		return ResponseEntity.ok(data);
	}
	
}
