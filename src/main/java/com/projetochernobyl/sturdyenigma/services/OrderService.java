package com.projetochernobyl.sturdyenigma.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Order;
import com.projetochernobyl.sturdyenigma.domain.OrderItem;
import com.projetochernobyl.sturdyenigma.domain.PaymentBarrCode;
import com.projetochernobyl.sturdyenigma.domain.enums.PaymentSituation;
import com.projetochernobyl.sturdyenigma.repository.OrderItemRepository;
import com.projetochernobyl.sturdyenigma.repository.OrderRepository;
import com.projetochernobyl.sturdyenigma.repository.PaymentRepository;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository rep;
	
	@Autowired
	private BarrcodeService barrcodeService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public Order findById(Long id) {
		Optional<Order> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("SIC-7", "Order not found. Id: " + id));
	}
	
	@Transactional
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setInstant(new Date());
		obj.getPayment().setSituation(PaymentSituation.PENDING);
		obj.getPayment().setOrder(obj);
		if (obj.getPayment() instanceof PaymentBarrCode) {
			PaymentBarrCode pay = (PaymentBarrCode) obj.getPayment();
			barrcodeService.fillData(pay, obj.getInstant());
		}
		obj = rep.save(obj);
		paymentRepository.save(obj.getPayment());
		
		for(OrderItem oi : obj.getItens()) {
			oi.setDiscount(0.0);
			oi.setPrice(productService.findById(oi.getProduct().getId()).getPrice());
			oi.setOrder(obj);
		}
		orderItemRepository.saveAll(obj.getItens());
		return obj;
	}
}
