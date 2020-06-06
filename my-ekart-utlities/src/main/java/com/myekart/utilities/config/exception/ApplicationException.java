package com.myekart.utilities.config.exception;

public class ApplicationException extends Exception {

	private Object[] args;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		// default constructor
	}

	public ApplicationException(String message, Object... args) {
		super(message);
		this.args = args;
	}

	public ApplicationException(String message, Throwable cause, Object... args) {
		super(message, cause);
		this.args = args;
	}

	public Object[] getArguments() {
		return args;
	}
}
