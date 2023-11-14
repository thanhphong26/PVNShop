package com.pvnshop.models;

public class ProductModel {
	private int productID;
	private String productName;
	private String version;
	private String description;
	private int price;
	private String color;
	private String size;
	private int inventory;
	private String image;
	private int cateID;
	private int manuID;
	public ProductModel() {
		super();
	}
	public ProductModel(int productID, String productName, String version, String description, int price, String color,
			String size, int inventory, String image, int cateID, int manuID) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.version = version;
		this.description = description;
		this.price = price;
		this.color = color;
		this.size = size;
		this.inventory = inventory;
		this.image = image;
		this.cateID = cateID;
		this.manuID = manuID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public int getManuID() {
		return manuID;
	}
	public void setManuID(int manuID) {
		this.manuID = manuID;
	}
	@Override
	public String toString() {
		return "ProductModel [productID=" + productID + ", productName=" + productName + ", version=" + version
				+ ", description=" + description + ", price=" + price + ", color=" + color + ", size=" + size
				+ ", inventory=" + inventory + ", image=" + image + ", cateID=" + cateID + ", manuID=" + manuID + "]";
	}
	
}
