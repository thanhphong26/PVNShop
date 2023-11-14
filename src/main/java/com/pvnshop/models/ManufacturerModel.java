package com.pvnshop.models;

public class ManufacturerModel {
	private int manuID;
	private String manuName;
	private String address;
	private String email;
	public ManufacturerModel() {
		super();
	}
	public ManufacturerModel(int manuID, String manuName, String address, String email) {
		super();
		this.manuID = manuID;
		this.manuName = manuName;
		this.address = address;
		this.email = email;
	}
	public int getManuID() {
		return manuID;
	}
	public void setManuID(int manuID) {
		this.manuID = manuID;
	}
	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
