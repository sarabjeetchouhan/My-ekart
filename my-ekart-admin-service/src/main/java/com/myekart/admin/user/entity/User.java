package com.myekart.admin.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.myekart.admin.address.entity.Address;
import com.myekart.admin.paymentInfo.entity.PaymentInfo;
import com.myekart.utilities.commons.BaseEntity;

@Entity
@Table(name = "app_user")
public class User extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = false)
	private String userId;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String passwordEncry;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "user_type", nullable = false)
	private String userType;

	@OneToMany
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	private List<Address> addresses;

	@OneToMany
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	private List<PaymentInfo> paymentInfos;

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
		return passwordEncry;
	}

	public void setPassword(String password) {
		this.passwordEncry = password;
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

	public String getPasswordEncry() {
		return passwordEncry;
	}

	public void setPasswordEncry(String passwordEncry) {
		this.passwordEncry = passwordEncry;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<PaymentInfo> getPaymentInfos() {
		return paymentInfos;
	}

	public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

}
