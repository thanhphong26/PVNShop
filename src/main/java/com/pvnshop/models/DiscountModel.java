package com.pvnshop.models;

import java.math.BigDecimal;
import java.sql.Date;

public class DiscountModel {
	private int discountID;
	private BigDecimal percent;
	private int minium;
	private int maximum;
	private Date dateStart;
	private Date dateEnd;
	private int quantity;
	public DiscountModel() {
		super();
	}
	public DiscountModel(int discountID, BigDecimal percent, int minium, int maximum, Date dateStart, Date dateEnd,
			int quantity) {
		super();
		this.discountID = discountID;
		this.percent = percent;
		this.minium = minium;
		this.maximum = maximum;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.quantity = quantity;
	}
	public int getDiscountID() {
		return discountID;
	}
	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}
	public BigDecimal getPercent() {
		return percent;
	}
	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}
	public int getMinium() {
		return minium;
	}
	public void setMinium(int minium) {
		this.minium = minium;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
