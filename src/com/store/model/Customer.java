package com.store.model;

public class Customer {
	
	protected String customerID;

	public Customer() {
	}
	
	public Customer(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
}
