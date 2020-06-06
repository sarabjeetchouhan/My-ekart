package com.myekart.inventory.item.exception;

import com.myekart.utilities.config.exception.ApplicationException;

public class InventoryItemException extends ApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public InventoryItemException(String message, Object... args) {
		super(message, args);
	}

	public InventoryItemException(String message, Throwable cause, Object... args) {
		super(message, cause, args);
	}

}
