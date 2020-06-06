package com.myekart.utilities.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myekart.utilities.commons.ResponseModel;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "rawtypes" })
	@ExceptionHandler(ApplicationException.class)
	public final ResponseEntity<ResponseModel> handleAllExceptions(ApplicationException ex, WebRequest request) {
		String message = ex.getLocalizedMessage();
		Object[] args = ex.getArguments();
		ResponseStatus error = new ResponseStatus(ResponseStatus.FAILED, message, args);
		ResponseModel responseModel = (ResponseModel) new Object();
		responseModel.setStatus(error);
		return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
