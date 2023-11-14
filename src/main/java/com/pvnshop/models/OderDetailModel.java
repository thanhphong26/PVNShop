package com.pvnshop.models;

public class OderDetailModel {
	private int orderID;
	private int productID;
	private int quantity;
	public OderDetailModel() {
		super();
	}
	public OderDetailModel(int orderID, int productID, int quantity) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
