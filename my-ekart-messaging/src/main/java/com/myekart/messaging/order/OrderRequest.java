package com.myekart.messaging.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myekart.messaging.admin.address.AddressRequest;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoRequest;
import com.myekart.utilities.commons.RequestModel;

public class OrderRequest extends RequestModel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String orderId;

	private String userId;

	private String emailId;

	private PaymentInfoRequest paymentInfo;

	private AddressRequest address;

	private BigDecimal totalBill;
	
	private Date orderDate;

	private List<OrderItemsRequest> orderItems;

	private String statusCd;

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

	public PaymentInfoRequest getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfoRequest paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public AddressRequest getAddress() {
		return address;
	}

	public void setAddress(AddressRequest address) {
		this.address = address;
	}

	public BigDecimal getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(BigDecimal totalBill) {
		this.totalBill = totalBill;
	}

	public List<OrderItemsRequest> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemsRequest> orderItems) {
		this.orderItems = orderItems;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderRequest [");
		if (orderId != null) {
			builder.append("orderId=");
			builder.append(orderId);
			builder.append(", ");
		}
		if (userId != null) {
			builder.append("userId=");
			builder.append(userId);
			builder.append(", ");
		}
		if (emailId != null) {
			builder.append("emailId=");
			builder.append(emailId);
			builder.append(", ");
		}
		if (paymentInfo != null) {
			builder.append("paymentInfo=");
			builder.append(paymentInfo);
			builder.append(", ");
		}
		if (address != null) {
			builder.append("address=");
			builder.append(address);
			builder.append(", ");
		}
		if (totalBill != null) {
			builder.append("totalBill=");
			builder.append(totalBill);
			builder.append(", ");
		}
		if (orderDate != null) {
			builder.append("orderDate=");
			builder.append(orderDate);
			builder.append(", ");
		}
		if (orderItems != null) {
			builder.append("orderItems=");
			builder.append(orderItems);
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
