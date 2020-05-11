package com.projetochernobyl.sturdyenigma.resouces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryResource {
	
	@GetMapping
	public String list() {
		return "REST is working";
	}
	
}
