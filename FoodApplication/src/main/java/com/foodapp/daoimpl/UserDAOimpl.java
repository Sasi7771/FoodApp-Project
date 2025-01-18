package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.UserDAO;
import com.foodapp.daoConnect.DBConnection;
import com.foodapp.model.User;

public class UserDAOimpl implements UserDAO
{
	static ArrayList<User> userList=new ArrayList<User>();
	public final static String INSERTQUERY="insert into user(userid,username,password,email,address) values(?,?,?,?,?)";
	public final static String FETCHALL="select * from user";
	public final static String FETCHONE="select * from user where userid=?";
	public final static String UPDATE="update user set address=? where userid=?";
	public final static String DELETE="delete from user where userid=?";
	private static Connection con;
	
	
	static
	{
		con=DBConnection.connect();	
	}


	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private User u;
	
	
	@Override
	public int insert(User u) {
		
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1, u.getUserid());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getAddress());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	

	@Override
	public ArrayList<User> fetchall() 
	{
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			
			userList=extractUserListFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
		
	}
	
	
	
	
	ArrayList<User> extractUserListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				userList.add(new User(
				resultSet.getInt("userid"),
				resultSet.getString("username"),
				resultSet.getString("password"),
				resultSet.getString("email"),
				resultSet.getString("address")
				));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
	}



	@Override
	public User fetchone(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			userList=extractUserListFromResultSet(resultSet);
			u=userList.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
		
	}



	@Override
	public int update(int id, String adress) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, id);
			pstmt.setString(1, adress);
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public int delete(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			 return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
	
	
}
