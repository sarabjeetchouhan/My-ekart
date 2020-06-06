package com.myekart.admin.address.exception;

import com.myekart.utilities.config.exception.ApplicationException;

public class AddressException extends ApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public AddressException(String message, Object... args) {
		super(message, args);
	}

	public AddressException(String message, Throwable cause, Object... args) {
		super(message, cause, args);
	}

}
