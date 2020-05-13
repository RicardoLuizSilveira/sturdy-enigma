package com.projetochernobyl.sturdyenigma.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetochernobyl.sturdyenigma.domain.Order;
import com.projetochernobyl.sturdyenigma.resouces.responses.ResponseDTO;
import com.projetochernobyl.sturdyenigma.services.OrderService;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<Order>> findById(@PathVariable(value = "id") Long id) {
		ResponseDTO<Order> data = new ResponseDTO<>();
		data.setData(service.findById(id));
		return ResponseEntity.ok(data);
	}
	
}
