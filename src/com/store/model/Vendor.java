package com.store.model;

public class Vendor {
	
	private String vendorName;
	private String vendorDescription;
	
	public Vendor(String vendorName, String vendorDescription) {
		this.vendorName = vendorName;
		this.vendorDescription = vendorDescription;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorDescription() {
		return vendorDescription;
	}

	public void setVendorDescription(String vendorDescription) {
		this.vendorDescription = vendorDescription;
	}
}
