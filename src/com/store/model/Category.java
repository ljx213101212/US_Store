package com.store.model;

import java.util.List;

public class Category {

	private String categoryCode;
	private String categoryName;
	private List<Vendor> vendors;

	public Category(String categoryCode, String categoryName,
			List<Vendor> vendors) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.vendors = vendors;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}
}
