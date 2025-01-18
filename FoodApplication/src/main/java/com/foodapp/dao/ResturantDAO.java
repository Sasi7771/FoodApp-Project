package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.Resturant;

public interface ResturantDAO 
{
	int insert(Resturant r);
	ArrayList<Resturant> fetchall();
	Resturant fetchone(int id);
	int update(int id,String ImagePath);
	int delete(int id);
}
