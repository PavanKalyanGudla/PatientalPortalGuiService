package com.medical.modal;

public class CartOrders {

	private int order_id ;
    private String patientId ;
    private int cart_id ;
    private double total_amount ;
    private String order_status ;
    private String products;
    private String created_at ;
    private Cart cart;
    
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "CartOrders [order_id=" + order_id + ", patientId=" + patientId + ", cart_id=" + cart_id
				+ ", total_amount=" + total_amount + ", order_status=" + order_status + ", products=" + products
				+ ", created_at=" + created_at + ", cart=" + cart + "]";
	}
    
}
