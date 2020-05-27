package com.projetochernobyl.sturdyenigma.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.PaymentBarrCode;

@Service
public class BarrcodeService {
	
	public void fillData(PaymentBarrCode payment, Date instant) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instant);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		payment.setDueDAte(cal.getTime());
	}
}
