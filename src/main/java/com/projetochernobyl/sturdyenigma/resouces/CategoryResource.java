package com.projetochernobyl.sturdyenigma.resouces;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Category obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<Category>> updateCategory(@PathVariable(value = "id") Long id, @RequestBody Category obj) {
		ResponseDTO<Category> data = new ResponseDTO<>();
		obj.setId(id);
		data.setData(service.update(obj));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}






