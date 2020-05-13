package com.projetochernobyl.sturdyenigma.services.exceptions;

public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public DataIntegrityException(String errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
