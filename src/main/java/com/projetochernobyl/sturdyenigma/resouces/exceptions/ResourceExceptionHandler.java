package com.projetochernobyl.sturdyenigma.resouces.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetochernobyl.sturdyenigma.resouces.responses.ResponseDTO;
import com.projetochernobyl.sturdyenigma.services.exceptions.DataIntegrityException;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ResponseDTO<?>> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		List<StandardError> errors = new ArrayList<>();
		errors.add(new StandardError(Instant.now(), status.value(), e.getErrorCode(), e.getMessage(), request.getRequestURI()));
		
		ResponseDTO<StandardError> err = new ResponseDTO<>();
		err.setErrors(errors);
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<ResponseDTO<?>> dataIntegrityViolationException(DataIntegrityException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		List<StandardError> errors = new ArrayList<>();
		errors.add(new StandardError(Instant.now(), status.value(), e.getErrorCode(), e.getMessage(), request.getRequestURI()));
		
		ResponseDTO<StandardError> err = new ResponseDTO<>();
		err.setErrors(errors);
		return ResponseEntity.status(status).body(err);
	}

}
