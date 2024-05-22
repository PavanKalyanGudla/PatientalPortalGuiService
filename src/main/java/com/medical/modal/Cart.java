package com.medical.modal;

public class Cart {
	
	private int cart_id;
    private String patientId;
    private String products;
    private String added_at;
    
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public String getAdded_at() {
		return added_at;
	}
	public void setAdded_at(String added_at) {
		this.added_at = added_at;
	}
	
}
