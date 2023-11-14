package com.pvnshop.models;

public class UserModel {
	private String username;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String password;
	private byte isAdmin;
	public UserModel() {
		super();
	}
	public UserModel(String username, String name, String phone, String email, String address, String password,
			byte isAdmin) {
		super();
		this.username = username;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public UserModel(String username, String name, String phone, String email, String address, String password) {
		super();
		this.username = username;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
