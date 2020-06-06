package com.myekart.inventory.item.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.myekart.utilities.commons.BaseEntity;

@Entity
@Table(name = "inventory_item")
public class InventoryItem extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "item_id", nullable = false)
	private String itemId;

	@Column(name = "category", nullable = false)
	private String category;

	@Column(name = "sub_category")
	private String subCategory;

	@Column(name = "item_name", nullable = false)
	private String itemName;

	@Column(name = "description")
	private String description;

	@Column(name = "available_quantity")
	private int availableQuantity;

	@Column(name = "price")
	private BigDecimal price;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
