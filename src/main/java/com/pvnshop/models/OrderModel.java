package com.pvnshop.models;

import java.sql.Date;

public class OrderModel {
	private int orderID;
	private Date time;
	private int total;
	private int state;
	private String note;
	private String payment_method;
	private String user_name;
	private Integer discount_id;
	public OrderModel(int orderID, Date time, int total, int state, String note, String payment_method,
			String user_name, int discount_id, String shipping_method, int ship_cost) {
		super();
		this.orderID = orderID;
		this.time = time;
		this.total = total;
		this.state = state;
		this.note = note;
		this.payment_method = payment_method;
		this.user_name = user_name;
		this.discount_id = discount_id;
		this.shipping_method = shipping_method;
		this.ship_cost = ship_cost;
	}
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(Integer discount_id) {
		this.discount_id = discount_id;
	}
	public String getShipping_method() {
		return shipping_method;
	}
	public void setShipping_method(String shipping_method) {
		this.shipping_method = shipping_method;
	}
	public int getShip_cost() {
		return ship_cost;
	}
	public void setShip_cost(int ship_cost) {
		this.ship_cost = ship_cost;
	}
	private String shipping_method;
	private int ship_cost;

}