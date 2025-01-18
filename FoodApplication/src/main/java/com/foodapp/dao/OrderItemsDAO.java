package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.OrderItems;

public interface OrderItemsDAO 
{	
	int insert(OrderItems oi);
	ArrayList<OrderItems> fetchall();
	OrderItems fetchone(int id);
	int update(int quantity,int id);
	int delete(int id);
}
