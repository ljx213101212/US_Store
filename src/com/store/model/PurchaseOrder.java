package com.store.model;

import java.util.List;

public class PurchaseOrder {
	
	private List<PurchaseItem> purchaseItems;
	private Vendor vendor;
	
	public PurchaseOrder(List<PurchaseItem> purchaseItems, Vendor vendor) {
		this.purchaseItems = purchaseItems;
		this.vendor = vendor;
	}
	
	public List<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}
	
	public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}
	
	public Vendor getVendor() {
		return vendor;
	}
	
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}
