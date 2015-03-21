package com.store.model;

import java.util.List;

public class Store {
	
	private List<User> users;
	private List<MemberCustomer> members;
	private List<Product> products;
	private List<Category> categories;
	private List<Discount> discounts;
	private List<Vendor> vendors;
	private List<Transaction> transactions;
	private PurchaseOrder purchaseOrders;
	
	public Store(List<User> users, List<MemberCustomer> members,
			List<Product> products, List<Category> categories,
			List<Discount> discounts, List<Vendor> vendors,
			List<Transaction> transactions, PurchaseOrder purchaseOrders) {
		this.users = users;
		this.members = members;
		this.products = products;
		this.categories = categories;
		this.discounts = discounts;
		this.vendors = vendors;
		this.transactions = transactions;
		this.purchaseOrders = purchaseOrders;
	}

	public boolean verifyLogin(String userName, String userPassword) {
		return true;
	}
	
	public void addMember(String memberName, String customerID) {
	}
	
	public void addCategory(String categoryCode, String catergoryName) {
	}
	
	public void checkoutItems() {
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<MemberCustomer> getMembers() {
		return members;
	}

	public void setMembers(List<MemberCustomer> members) {
		this.members = members;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public PurchaseOrder getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(PurchaseOrder purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}
}
