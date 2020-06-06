package com.myekart.messaging.admin.address;

import com.myekart.utilities.commons.RequestModel;

public class AddressRequest extends RequestModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String userId;

	private String addressId;

	private String addressType;

	private String addressLine1;

	private String addressLine2;

	private String street;

	private String landmark;

	private String city;

	private String state;

	private String country;

	private String pincode;

	private String statusCd;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressRequest [");
		if (userId != null) {
			builder.append("userId=");
			builder.append(userId);
			builder.append(", ");
		}
		if (addressId != null) {
			builder.append("addressId=");
			builder.append(addressId);
			builder.append(", ");
		}
		if (addressType != null) {
			builder.append("addressType=");
			builder.append(addressType);
			builder.append(", ");
		}
		if (addressLine1 != null) {
			builder.append("addressLine1=");
			builder.append(addressLine1);
			builder.append(", ");
		}
		if (addressLine2 != null) {
			builder.append("addressLine2=");
			builder.append(addressLine2);
			builder.append(", ");
		}
		if (street != null) {
			builder.append("street=");
			builder.append(street);
			builder.append(", ");
		}
		if (landmark != null) {
			builder.append("landmark=");
			builder.append(landmark);
			builder.append(", ");
		}
		if (city != null) {
			builder.append("city=");
			builder.append(city);
			builder.append(", ");
		}
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}
		if (country != null) {
			builder.append("country=");
			builder.append(country);
			builder.append(", ");
		}
		if (pincode != null) {
			builder.append("pincode=");
			builder.append(pincode);
			builder.append(", ");
		}
		if (statusCd != null) {
			builder.append("statusCd=");
			builder.append(statusCd);
		}
		builder.append("]");
		return builder.toString();
	}

}
