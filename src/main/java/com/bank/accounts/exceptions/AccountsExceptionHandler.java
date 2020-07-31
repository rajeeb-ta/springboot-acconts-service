package com.bank.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountsExceptionHandler {
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Exception> handleException(RuntimeException exception) {
	    return new ResponseEntity<Exception>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
