package com.myekart.utilities.config.exception;

import java.io.Serializable;

public class ResponseStatus implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";
	private String status;
	private String message;
	private Object[] arguments;
	private String description;

	public ResponseStatus() {
		// default constructor
	}

	public ResponseStatus(String status) {
		this.status = status;
	}

	public ResponseStatus(String status, String message, Object... arguments) {
		this.status = status;
		this.message = message;
		this.arguments = arguments;
		this.description = String.format(message, arguments);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
