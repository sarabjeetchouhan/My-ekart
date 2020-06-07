package com.myekart.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.myekart.utilities.commons.BaseEntity;

@Entity
@Table(name = "ordered_items")
public class OrderedItems extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	@Column(name = "order_item_id", nullable = false)
	private String orderItemId;

	@Column(name = "order_id", nullable = false)
	private String orderId;

	@Column(name = "item_id", nullable = false)
	private String itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

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

}
