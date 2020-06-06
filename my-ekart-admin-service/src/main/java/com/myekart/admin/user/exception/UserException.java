package com.myekart.admin.user.exception;

import com.myekart.utilities.config.exception.ApplicationException;

public class UserException extends ApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public UserException(String message, Object... args) {
		super(message, args);
	}

	public UserException(String message, Throwable cause, Object... args) {
		super(message, cause, args);
	}

}
