package com.store.model;

import java.util.Date;

public class Discount {
	
	protected String discountCode;
	protected String discountDescription;
	protected Date startDate;
	protected int discountPeriod;
	protected float discountPercentage;
	
	public Discount(String discountCode, String discountDescription,
			Date startDate, int discountPeriod, float discountPercentage) {
		this.discountCode = discountCode;
		this.discountDescription = discountDescription;
		this.startDate = startDate;
		this.discountPeriod = discountPeriod;
		this.discountPercentage = discountPercentage;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getDiscountDescription() {
		return discountDescription;
	}

	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDiscountPeriod() {
		return discountPeriod;
	}

	public void setDiscountPeriod(int discountPeriod) {
		this.discountPeriod = discountPeriod;
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
}
