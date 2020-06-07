package com.myekart.utilities.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
 
	@ExceptionHandler(ApplicationException.class)
	public final ResponseEntity<ResponseStatus> handleAllExceptions(ApplicationException ex, WebRequest request) {
		String message = ex.getLocalizedMessage();
		Object[] args = ex.getArguments();
		ResponseStatus error = new ResponseStatus(ResponseStatus.FAILED, message, args);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
