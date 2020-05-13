package com.projetochernobyl.sturdyenigma.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Order;
import com.projetochernobyl.sturdyenigma.repository.OrderRepository;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository rep;
	
	public Order findById(Long id) {
		Optional<Order> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("SIC-7", "Order not found. Id: " + id));
	}
}
