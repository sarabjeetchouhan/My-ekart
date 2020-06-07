package com.myekart.utilities.enums;

public enum OrderStatus {

	ORDER_PLACED("ORDER_PLACED"), IN_PROGRESS("IN_PROGRESS"), OUT_FOR_DELIVERY("OUT_FOR_DELIVERY"),
	DELIVERED("DELIVERED"), CANCELLED("CANCELLED");

	private String deliveryStatus;

	private OrderStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String deliveryStatus() {
		return deliveryStatus;
	}

}
