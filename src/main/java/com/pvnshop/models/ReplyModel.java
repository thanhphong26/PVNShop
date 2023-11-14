package com.pvnshop.models;

public class ReplyModel {
	private int rateID;
	private int replyID;
	public ReplyModel() {
		super();
	}
	public ReplyModel(int rateID, int replyID) {
		super();
		this.rateID = rateID;
		this.replyID = replyID;
	}
	public int getRateID() {
		return rateID;
	}
	public void setRateID(int rateID) {
		this.rateID = rateID;
	}
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}
	
}
