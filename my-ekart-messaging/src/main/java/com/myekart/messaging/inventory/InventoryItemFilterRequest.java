/*
 * 
 */
package com.myekart.messaging.inventory;

import java.math.BigDecimal;

import com.myekart.utilities.commons.RequestModel;

public class InventoryItemFilterRequest extends RequestModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String category;

	private String subCategory;

	private String name;

	private BigDecimal fromPrice;

	private BigDecimal toPrice;

	private boolean sortByCategory = Boolean.FALSE;

	private boolean sortBySubCategory = Boolean.FALSE;

	private boolean sortByName = Boolean.FALSE;

	private boolean sortByprice = Boolean.FALSE;

	private int pageSize;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getFromPrice() {
		return fromPrice;
	}

	public void setFromPrice(BigDecimal fromPrice) {
		this.fromPrice = fromPrice;
	}

	public BigDecimal getToPrice() {
		return toPrice;
	}

	public void setToPrice(BigDecimal toPrice) {
		this.toPrice = toPrice;
	}

	public boolean isSortByCategory() {
		return sortByCategory;
	}

	public void setSortByCategory(boolean sortByCategory) {
		this.sortByCategory = sortByCategory;
	}

	public boolean isSortBySubCategory() {
		return sortBySubCategory;
	}

	public void setSortBySubCategory(boolean sortBySubCategory) {
		this.sortBySubCategory = sortBySubCategory;
	}

	public boolean isSortByName() {
		return sortByName;
	}

	public void setSortByName(boolean sortByName) {
		this.sortByName = sortByName;
	}

	public boolean isSortByprice() {
		return sortByprice;
	}

	public void setSortByprice(boolean sortByprice) {
		this.sortByprice = sortByprice;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
