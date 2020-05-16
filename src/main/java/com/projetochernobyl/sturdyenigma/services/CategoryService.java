package com.projetochernobyl.sturdyenigma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.dto.CategoryDTO;
import com.projetochernobyl.sturdyenigma.repository.CategoryRepository;
import com.projetochernobyl.sturdyenigma.services.exceptions.DataIntegrityException;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository rep;
	
	public Category findById(Long id) {
		Optional<Category> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("SIC-500", "Category not found. id: " + id));
	}
	
	public List<Category> findAll() {
		return rep.findAll();
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		obj = rep.save(obj);
		return obj;
	}

	public Category update(Category obj) {
		Category newObj = findById(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}
	
	private void updateData(Category newObj, Category obj) {
		newObj.setName(obj.getName());
	}

	public void delete(Long id) {
		findById(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("SIC-8745", "Its not possible delete a Category that contains products");
		}
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return rep.findAll(pageRequest);
	}
	
	public Category fromDto(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}
}








