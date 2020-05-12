package com.projetochernobyl.sturdyenigma.domain.enums;

public enum ClientType {
	NATURAL_PERSON(0, "Natural Person"),
	JURIDICAL_PERSON(1, "Juridical Person");
	
	private int code;
	private String description;
	
	private ClientType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for ( ClientType type : ClientType.values()) {
			if (code.equals(type.getCode())) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid code: " + code + " for a Client Type");
	}
}
