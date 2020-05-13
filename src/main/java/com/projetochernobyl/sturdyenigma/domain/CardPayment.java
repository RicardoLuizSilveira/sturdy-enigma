package com.projetochernobyl.sturdyenigma.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.projetochernobyl.sturdyenigma.domain.enums.PaymentSituation;

@Entity
public class CardPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Date dueDAte;
	private Date payDate;
	
	public CardPayment() {
	}
	public CardPayment(Long id, PaymentSituation situation, Order order, Date dueDAte, Date payDate) {
		super(id, situation, order);
		this.dueDAte = dueDAte;
		this.payDate = payDate;
	}
	public Date getDueDAte() {
		return dueDAte;
	}
	public void setDueDAte(Date dueDAte) {
		this.dueDAte = dueDAte;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
}
