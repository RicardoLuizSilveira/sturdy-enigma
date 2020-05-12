package com.projetochernobyl.sturdyenigma.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public ObjectNotFoundException(String errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
