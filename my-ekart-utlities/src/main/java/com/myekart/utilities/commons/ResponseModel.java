package com.myekart.utilities.commons;

import java.io.Serializable;

import com.myekart.utilities.config.exception.ResponseStatus;

public abstract class ResponseModel<T> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private ResponseStatus status;

	public abstract void setMessage(T message);

	public abstract T getMessage();

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

}
