package com.projetochernobyl.sturdyenigma.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.projetochernobyl.sturdyenigma.domain.enums.PaymentSituation;

@JsonTypeName("paymentBarrCode")
@Entity
public class PaymentBarrCode extends Payment{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dueDAte;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date payDate;
	
	public PaymentBarrCode() {
	}
	public PaymentBarrCode(Long id, PaymentSituation situation, Order order, Date dueDAte, Date payDate) {
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
