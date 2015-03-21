package com.store.model;

public class TransactionItem {
	
	private Product product;
	private int quantity;
	private float pricePerUnit;
	
	public TransactionItem(Product product, int quantity, float pricePerUnit) {
		this.product = product;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
}
