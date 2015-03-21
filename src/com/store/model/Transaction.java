package com.store.model;

import java.util.Date;
import java.util.List;

public class Transaction {
	
	private int transactionID;
	private String customerID;
	private Date transactionDate;
	private List<TransactionItem> transactionItems;
	
	public Transaction(int transactionID, String customerID,
			Date transactionDate, List<TransactionItem> transactionItems) {
		this.transactionID = transactionID;
		this.customerID = customerID;
		this.transactionDate = transactionDate;
		this.transactionItems = transactionItems;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public List<TransactionItem> getTransactionItems() {
		return transactionItems;
	}

	public void setTransactionItems(List<TransactionItem> transactionItems) {
		this.transactionItems = transactionItems;
	}
}
