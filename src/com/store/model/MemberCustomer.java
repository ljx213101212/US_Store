package com.store.model;

public class MemberCustomer extends Customer {
	
	private String memberName;
	private int loyaltyPoints;
	
	public MemberCustomer(String customerID, String memberName,
			int loyaltyPoints) {
		this.customerID = customerID;
		this.memberName = memberName;
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
}
