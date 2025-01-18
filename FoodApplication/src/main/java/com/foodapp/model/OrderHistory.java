package com.foodapp.model;

public class OrderHistory 
{
	private int OrderHistoryId;
	private int OrderId;
	private int UserId;
	private int TotalAmount;
	private String Status;
	public int getOrderHistoryId() {
		return OrderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		OrderHistoryId = orderHistoryId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public OrderHistory() {
		super();
	}
	public OrderHistory(int orderHistoryId, int orderId, int userId, int totalAmount, String status) {
		super();
		OrderHistoryId = orderHistoryId;
		OrderId = orderId;
		UserId = userId;
		TotalAmount = totalAmount;
		Status = status;
	}
	@Override
	public String toString() {
		return  OrderHistoryId + "  " + OrderId + "  " + UserId+ "  " + TotalAmount + "  " + Status ;
				
	}
	
	
	
	
}
