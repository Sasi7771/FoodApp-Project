package com.foodapp.model;

public class Orders 
{
	private int OrderId;
	private int userid;
	private int resturantid;
	private double TotalAmount;
	private String Status;
	private String PaymentMode;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getResturantid() {
		return resturantid;
	}
	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPaymentMode() {
		return PaymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}
	public Orders() {
		super();
	}
	public Orders(int orderId, int userid, int resturantid, double totalAmount, String status, String paymentMode) {
		super();
		OrderId = orderId;
		this.userid = userid;
		this.resturantid = resturantid;
		TotalAmount = totalAmount;
		Status = status;
		PaymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return  OrderId + "  " + userid + "  " + resturantid + "  "+ TotalAmount + "  " + Status + "  " + PaymentMode ;
				
	}
	
	
	
	
}
