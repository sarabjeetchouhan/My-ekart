package com.myekart.messaging.inventory;

import com.myekart.utilities.commons.ResponseModel;

public class InventoryResponse extends ResponseModel<InventoryItemRequest> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private InventoryItemRequest message;

	@Override
	public void setMessage(InventoryItemRequest message) {
		this.message = message;

	}

	@Override
	public InventoryItemRequest getMessage() {
		return message;
	}

}
