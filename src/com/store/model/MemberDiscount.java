package com.store.model;

import java.util.Date;

public class MemberDiscount extends Discount {

	public MemberDiscount(String discountCode, String discountDescription,
			Date startDate, int discountPeriod, float discountPercentage) {
		super(discountCode, discountDescription, startDate, discountPeriod,
				discountPercentage);
	}
	
}
