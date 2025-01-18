package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.Menu;

public interface MenuDAO 
{
	int insert(Menu m);
	ArrayList<Menu> fetchall();
	Menu fetchone(int id);
	ArrayList<Menu> fetchMenuByResturant(int ResturantId);
	int update(int id,String ImagePath);
	int delete(int id);
}
