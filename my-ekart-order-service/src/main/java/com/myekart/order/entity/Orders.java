package com.myekart.order.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.myekart.utilities.commons.BaseEntity;

@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "order_id", nullable = false)
	private String orderId;

	@Column(name = "user_id", nullable = false)
	private String userId;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "payment_mode")
	private int paymentMode;

	@Column(name = "payment_info_id")
	private String paymentInfoId;

	@Column(name = "address_id")
	private String addressId;

	@Column(name = "total_bill")
	private BigDecimal totalBill;

	@Column(name = "order_date")
	private Date orderDate;

	@OneToMany
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
	private List<OrderedItems> orderedItems;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(String paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public BigDecimal getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(BigDecimal totalBill) {
		this.totalBill = totalBill;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderedItems> getOrderItems() {
		return orderedItems;
	}

	public void setOrderItems(List<OrderedItems> orderedItems) {
		this.orderedItems = orderedItems;
	}

}
