package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.User;

public interface UserDAO 
{
	int insert(User u);
	ArrayList<User> fetchall();
	User fetchone(int id);
	int update(int id,String adress);
	int delete(int id);
}
