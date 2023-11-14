package com.pvnshop.models;

public class RateModel {
	private int rateID;
	private String context;
	private int productID;
	private int start;
	private String username;
	public RateModel() {
		super();
	}
	public RateModel(int rateID, String context, int productID, int start, String username) {
		super();
		this.rateID = rateID;
		this.context = context;
		this.productID = productID;
		this.start = start;
		this.username = username;
	}
	public int getRateID() {
		return rateID;
	}
	public void setRateID(int rateID) {
		this.rateID = rateID;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
