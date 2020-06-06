package com.myekart.admin.paymentInfo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.myekart.utilities.commons.BaseEntity;

@Entity
@Table(name = "payment_info")
public class PaymentInfo extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1928044585963434642L;

	@Column(name = "user_id", nullable = false)
	private String userId;

	@Column(name = "payment_info_id", nullable = false)
	private String paymentInfoId;

	@Column(name = "payment_mode", nullable = false)
	private int paymentMode;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "cvv")
	private String cvv;

	@Column(name = "expiry_month_year")
	private String expiryMonthYear;

	@Column(name = "upi_id")
	private String upiId;

	@Column(name = "payee_name")
	private String payeeName;

	@Column(name = "payee_acc_number")
	private String payeeAccountNumber;

	@Column(name = "bank_name")
	private String bankName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(String paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
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

}
