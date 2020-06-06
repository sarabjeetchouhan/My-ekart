package com.myekart.messaging.admin.user;

import java.util.List;

import com.myekart.messaging.admin.address.AddressRequest;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoRequest;
import com.myekart.utilities.commons.RequestModel;

public class UserRequest extends RequestModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String userId;

	private String userName;

	private String password;

	private String firstName;

	private String lastName;

	private String emailId;

	private String phoneNumber;

	private String userType;

	private List<AddressRequest> addresses;

	private List<PaymentInfoRequest> paymentInfos;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<AddressRequest> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressRequest> addresses) {
		this.addresses = addresses;
	}

	public List<PaymentInfoRequest> getPaymentInfos() {
		return paymentInfos;
	}

	public void setPaymentInfos(List<PaymentInfoRequest> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRequest [");
		if (userId != null) {
			builder.append("userId=");
			builder.append(userId);
			builder.append(", ");
		}
		if (userName != null) {
			builder.append("userName=");
			builder.append(userName);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (lastName != null) {
			builder.append("lastName=");
			builder.append(lastName);
			builder.append(", ");
		}
		if (emailId != null) {
			builder.append("emailId=");
			builder.append(emailId);
			builder.append(", ");
		}
		if (phoneNumber != null) {
			builder.append("phoneNumber=");
			builder.append(phoneNumber);
			builder.append(", ");
		}
		if (userType != null) {
			builder.append("userType=");
			builder.append(userType);
			builder.append(", ");
		}
		if (addresses != null) {
			builder.append("addresses=");
			builder.append(addresses);
			builder.append(", ");
		}
		if (paymentInfos != null) {
			builder.append("paymentInfos=");
			builder.append(paymentInfos);
		}
		builder.append("]");
		return builder.toString();
	}

}
