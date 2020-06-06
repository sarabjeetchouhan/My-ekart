package com.myekart.messaging.admin.paymentInfo;

import com.myekart.utilities.commons.RequestModel;

public class PaymentInfoRequest extends RequestModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String userId;

	private String paymentInfoId;

	private int paymentMode;

	private String cardNumber;

	private String cvv;

	private String expiryMonthYear;

	private String upiId;

	private String payeeName;

	private String payeeAccountNumber;

	private String bankName;

	private String statusCd;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpiryMonthYear() {
		return expiryMonthYear;
	}

	public void setExpiryMonthYear(String expiryMonthYear) {
		this.expiryMonthYear = expiryMonthYear;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeAccountNumber() {
		return payeeAccountNumber;
	}

	public void setPayeeAccountNumber(String payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(String paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
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
		builder.append("PaymentInfoRequest [");
		if (userId != null) {
			builder.append("userId=");
			builder.append(userId);
			builder.append(", ");
		}
		if (paymentInfoId != null) {
			builder.append("paymentInfoId=");
			builder.append(paymentInfoId);
			builder.append(", ");
		}
		builder.append("paymentMode=");
		builder.append(paymentMode);
		builder.append(", ");
		if (cardNumber != null) {
			builder.append("cardNumber=");
			builder.append(cardNumber);
			builder.append(", ");
		}
		if (cvv != null) {
			builder.append("cvv=");
			builder.append(cvv);
			builder.append(", ");
		}
		if (expiryMonthYear != null) {
			builder.append("expiryMonthYear=");
			builder.append(expiryMonthYear);
			builder.append(", ");
		}
		if (upiId != null) {
			builder.append("upiId=");
			builder.append(upiId);
			builder.append(", ");
		}
		if (payeeName != null) {
			builder.append("payeeName=");
			builder.append(payeeName);
			builder.append(", ");
		}
		if (payeeAccountNumber != null) {
			builder.append("payeeAccountNumber=");
			builder.append(payeeAccountNumber);
			builder.append(", ");
		}
		if (bankName != null) {
			builder.append("bankName=");
			builder.append(bankName);
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
