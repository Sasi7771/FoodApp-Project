package com.foodapp.model;

public class OrderItems 
{
	private int OrderItemsId;
	private int OrderId;
	private int MenuId;
	private int Quantity;
	private int ItemTotal;
	public int getOrderItemsId() {
		return OrderItemsId;
	}
	public void setOrderItemsId(int orderItemsId) {
		OrderItemsId = orderItemsId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getItemTotal() {
		return ItemTotal;
	}
	public void setItemTotal(int itemTotal) {
		ItemTotal = itemTotal;
	}
	public OrderItems() {
		super();
	}
	public OrderItems(int orderItemsId, int orderId, int menuId, int quantity, int itemTotal) {
		super();
		OrderItemsId = orderItemsId;
		OrderId = orderId;
		MenuId = menuId;
		Quantity = quantity;
		ItemTotal = itemTotal;
	}
	@Override
	public String toString() {
		return  OrderItemsId + "  " + OrderId + "  " + MenuId+ "  " + Quantity + "  " + ItemTotal;
				
	}
	
	
	
}


