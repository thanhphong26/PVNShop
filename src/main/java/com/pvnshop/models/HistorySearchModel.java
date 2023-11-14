package com.pvnshop.models;

public class HistorySearchModel {
	private String username;
	private String context;
	public HistorySearchModel(String username, String context) {
		super();
		this.username = username;
		this.context = context;
	}
	public HistorySearchModel() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
}
