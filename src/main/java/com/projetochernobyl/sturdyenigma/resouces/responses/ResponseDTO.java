package com.projetochernobyl.sturdyenigma.resouces.responses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projetochernobyl.sturdyenigma.resouces.exceptions.StandardError;

public class ResponseDTO<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private T data;
	private List<StandardError> errors = new ArrayList<>();
	
	public ResponseDTO() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<StandardError> getErrors() {
		return errors;
	}

	public void setErrors(List<StandardError> errors) {
		this.errors = errors;
	}
}
