package com.myekart.messaging.order;

import com.myekart.utilities.commons.RequestModel;

public class OrderItemsRequest extends RequestModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String orderItemId;

	private String orderId;

	private String itemId;

	private String itemName;

	private String description;

	private int quantity;

	private String statusCd;

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		builder.append("OrderItemsRequest [");
		if (orderItemId != null) {
			builder.append("orderItemId=");
			builder.append(orderItemId);
			builder.append(", ");
		}
		if (orderId != null) {
			builder.append("orderId=");
			builder.append(orderId);
			builder.append(", ");
		}
		if (itemId != null) {
			builder.append("itemId=");
			builder.append(itemId);
			builder.append(", ");
		}
		if (itemName != null) {
			builder.append("itemName=");
			builder.append(itemName);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		builder.append("quantity=");
		builder.append(quantity);
		builder.append(", ");
		if (statusCd != null) {
			builder.append("statusCd=");
			builder.append(statusCd);
		}
		builder.append("]");
		return builder.toString();
	}

}
