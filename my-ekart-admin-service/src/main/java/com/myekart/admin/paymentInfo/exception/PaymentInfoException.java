package com.myekart.admin.paymentInfo.exception;

import com.myekart.utilities.config.exception.ApplicationException;

public class PaymentInfoException extends ApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public PaymentInfoException(String message, Object... args) {
		super(message, args);
	}

	public PaymentInfoException(String message, Throwable cause, Object... args) {
		super(message, cause, args);
	}

}
