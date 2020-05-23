package com.projetochernobyl.sturdyenigma.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetochernobyl.sturdyenigma.domain.Product;
import com.projetochernobyl.sturdyenigma.dto.ProductDTO;
import com.projetochernobyl.sturdyenigma.resouces.responses.ResponseDTO;
import com.projetochernobyl.sturdyenigma.resouces.util.URL;
import com.projetochernobyl.sturdyenigma.services.ProductService;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/page")
	public ResponseEntity<ResponseDTO<Page<ProductDTO>>> search(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categories", defaultValue = "") String categoriesId,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
		ResponseDTO<Page<ProductDTO>> data = new ResponseDTO<>();
		List<Long> categoryIds = URL.decodeLongList(categoriesId);
		String nameDecoded = URL.decodeString(name);
		Page<Product> list = service.seach(nameDecoded, categoryIds, page, linesPerPage, direction, orderBy);
		Page<ProductDTO> listDto = list.map(p -> new ProductDTO(p));
		data.setData(listDto);
		return ResponseEntity.ok(data);
	}
}
