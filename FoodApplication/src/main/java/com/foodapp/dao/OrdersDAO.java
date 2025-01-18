package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.Orders;

public interface OrdersDAO 
{
	int insert(Orders o);
	ArrayList<Orders> fetchall();
	Orders fetchone(int id);
	int update(int id,String PaymentMode);
	int delete(int id);
}
