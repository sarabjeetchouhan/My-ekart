package com.myekart.messaging.admin.address;

import com.myekart.utilities.commons.ResponseModel;

public class AddressResponse extends ResponseModel<AddressRequest> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private AddressRequest message;

	@Override
	public void setMessage(AddressRequest message) {
		this.message = message;
	}

	@Override
	public AddressRequest getMessage() {
		return message;
	}

}
