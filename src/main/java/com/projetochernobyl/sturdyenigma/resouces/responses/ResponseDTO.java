package com.projetochernobyl.sturdyenigma.resouces.responses;

import java.io.Serializable;

import com.projetochernobyl.sturdyenigma.resouces.exceptions.StandardError;

public class ResponseDTO<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private T data;
	private StandardError error;
	
	public ResponseDTO() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public StandardError getError() {
		return error;
	}

	public void setError(StandardError error) {
		this.error = error;
	}

}
