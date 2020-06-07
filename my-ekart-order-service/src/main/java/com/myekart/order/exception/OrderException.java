package com.myekart.order.exception;

import com.myekart.utilities.config.exception.ApplicationException;

public class OrderException extends ApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public OrderException(String message, Object... objects) {
		super(message, objects);
	}

	public OrderException(String message, Throwable cause, Object... objects) {
		super(message, cause, objects);
	}

}
