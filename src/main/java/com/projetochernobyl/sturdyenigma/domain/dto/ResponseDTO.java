package com.projetochernobyl.sturdyenigma.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseDTO<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private T data;
	private List<String> errors = new ArrayList<>();
	
	public ResponseDTO() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
