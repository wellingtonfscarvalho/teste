package com.teste.pismo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.pismo.exception.NegocioException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleResourceNotFoundException(NegocioException ne) {
		return new ResponseEntity<>(ne.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
