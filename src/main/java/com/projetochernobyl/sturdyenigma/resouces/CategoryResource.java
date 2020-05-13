package com.projetochernobyl.sturdyenigma.resouces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.dto.CategoryDTO;
import com.projetochernobyl.sturdyenigma.resouces.responses.ResponseDTO;
import com.projetochernobyl.sturdyenigma.services.CategoryService;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
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
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<CategoryDTO>>> findAll() {
		ResponseDTO<List<CategoryDTO>> data = new ResponseDTO<>();
		List<Category> list = service.findAll();
		List<CategoryDTO> listDto = list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		data.setData(listDto);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<ResponseDTO<Page<CategoryDTO>>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		ResponseDTO<Page<CategoryDTO>> data = new ResponseDTO<>();
		Page<Category> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<CategoryDTO> listDto = list.map(x -> new CategoryDTO(x));
		data.setData(listDto);
		return ResponseEntity.ok(data);
	}
}






