package com.myekart.messaging.admin.user;

import com.myekart.utilities.commons.ResponseModel;

public class UserResponse extends ResponseModel<UserRequest> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private UserRequest message;

	@Override
	public void setMessage(UserRequest message) {
		this.message = message;
	}

	@Override
	public UserRequest getMessage() {
		return message;
	}

}
