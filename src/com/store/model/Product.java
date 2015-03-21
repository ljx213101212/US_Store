package com.store.model;

public class Product {
	
	private Category category;
	private String productName;
	private String productCode;
	private String productDescription;
	private int avaliableQuantity;
	private float price;
	private int barcodeNumber;
	private int reorderQuantity;
	private int orderQuantity;
	
	public Product(Category category, String productName, String productCode,
			String productDescription, int avaliableQuantity, float price,
			int barcodeNumber, int reorderQuantity, int orderQuantity) {
		this.category = category;
		this.productName = productName;
		this.productCode = productCode;
		this.productDescription = productDescription;
		this.avaliableQuantity = avaliableQuantity;
		this.price = price;
		this.barcodeNumber = barcodeNumber;
		this.reorderQuantity = reorderQuantity;
		this.orderQuantity = orderQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getAvaliableQuantity() {
		return avaliableQuantity;
	}

	public void setAvaliableQuantity(int avaliableQuantity) {
		this.avaliableQuantity = avaliableQuantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getBarcodeNumber() {
		return barcodeNumber;
	}

	public void setBarcodeNumber(int barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}

	public int getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
}
