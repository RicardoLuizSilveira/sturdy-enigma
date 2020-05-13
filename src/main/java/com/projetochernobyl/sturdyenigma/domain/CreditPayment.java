package com.projetochernobyl.sturdyenigma.domain;

import javax.persistence.Entity;

import com.projetochernobyl.sturdyenigma.domain.enums.PaymentSituation;

@Entity
public class CreditPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;

	public CreditPayment() {
	}

	public CreditPayment(Long id, PaymentSituation situation, Order order, Integer quantityPayments) {
		super(id, situation, order);
		this.numberOfInstallments = quantityPayments;
	}

	public Integer getQuantityPayments() {
		return numberOfInstallments;
	}

	public void setQuantityPayments(Integer quantityPayments) {
		this.numberOfInstallments = quantityPayments;
	}
}
