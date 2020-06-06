package com.myekart.messaging.admin.paymentInfo;

import com.myekart.utilities.commons.ResponseModel;

public class PaymentInfoResponse extends ResponseModel<PaymentInfoRequest> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private PaymentInfoRequest message;

	@Override
	public void setMessage(PaymentInfoRequest message) {
		this.message = message;
	}

	@Override
	public PaymentInfoRequest getMessage() {
		return message;
	}

}
