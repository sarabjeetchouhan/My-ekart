package com.myekart.messaging.order;

import com.myekart.utilities.commons.ResponseModel;

public class OrderResponse extends ResponseModel<OrderRequest> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private OrderRequest message;

	@Override
	public void setMessage(OrderRequest message) {
		this.message = message;
	}

	@Override
	public OrderRequest getMessage() {
		return message;
	}

}
