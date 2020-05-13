package com.projetochernobyl.sturdyenigma.domain.enums;

public enum PaymentSituation {
	PENDING(1, "Pending"),
	PAYED(2, "Payed"),
	CANCELED(3, "Canceled");
	
	private int code;
	private String description;
	
	private PaymentSituation(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentSituation toEnum(Integer code) {
		if (code == null) return null;
		
		for (PaymentSituation p : PaymentSituation.values()) {
			if (code.equals(p.getCode())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Invalid code: " + code + " for Payment Situation");
	}
}
