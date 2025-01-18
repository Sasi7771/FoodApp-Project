package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.OrderHistory;

public interface OrderHistoryDAO  
{
	int insert(OrderHistory oh);
	ArrayList<OrderHistory> fetchall();
	OrderHistory fetchone(int id);
	int update(int id,String Status);
	int delete(int id);
}
