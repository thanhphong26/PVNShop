package com.pvnshop.models;

public class CategoryModel {
	private int cateID;
	private String cateName;
	private int classID;
	public CategoryModel() {
		super();
	}
	public CategoryModel(int cateID, String cateName, int classID) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
		this.classID = classID;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	
}
