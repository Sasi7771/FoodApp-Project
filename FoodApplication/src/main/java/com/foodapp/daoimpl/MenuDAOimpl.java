package com.foodapp.daoimpl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.MenuDAO;
import com.foodapp.daoConnect.DBConnection;
import com.foodapp.model.Menu;
import com.foodapp.model.Resturant;

public class MenuDAOimpl implements MenuDAO 
{
	ArrayList<Menu>menulist=new ArrayList<Menu>();
	public final static String INSERTQUERY="insert into menu(MenuId,ResturantId,Name,Description,Price,isAvailable,ImagePath) values(?,?,?,?,?,?,?)";
	public final static String FETCHALL="select * from menu";
	public final static String FETCHONE="select * from menu where MenuId=?";
	public final static String FETCHMENUBYRESTURANT="select * from menu where ResturantId=?";
	public final static String UPDATE="update menu set ImagePath=? where MenuId=?";
	public final static String DELETE="delete from menu where MenuId=?";
	private static Connection con;
	
	static
	{
		con=DBConnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Menu m;

	@Override
	public int insert(Menu m) 
	{
		try
		{
			FileInputStream	fis=new FileInputStream("D:/foodapp/images/mehfil.png");
			
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1, m.getMenuId());
			pstmt.setInt(2, m.getResturantId());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getDescription());
			pstmt.setInt(5, m.getPrice());
			pstmt.setBoolean(6, m.isAvailable());
			pstmt.setBinaryStream(7, fis);
			
			return pstmt.executeUpdate();
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public ArrayList<Menu> fetchall() 
	{
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			menulist=extractMenutListFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menulist;
	}
	
	ArrayList<Menu> extractMenutListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				menulist.add(new Menu(
				resultSet.getInt("MenuId"),
				resultSet.getInt("ResturantId"),
				resultSet.getString("Name"),
				resultSet.getString("Description"),
				resultSet.getInt("Price"),
				resultSet.getBoolean("isAvailable"),
				resultSet.getString("ImagePath")
				));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menulist;
	}

	@Override
	public Menu fetchone(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			menulist=extractMenutListFromResultSet(resultSet);
			m=menulist.get(0);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int update(int id, String ImagePath) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, id);
			pstmt.setString(1, ImagePath);
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
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

	@Override
	public ArrayList<Menu> fetchMenuByResturant(int ResturantId) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCHMENUBYRESTURANT);
			pstmt.setInt(1, ResturantId);
			resultSet=pstmt.executeQuery();
			menulist=extractMenutListFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menulist;
	}
	
}
