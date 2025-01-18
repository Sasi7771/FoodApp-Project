package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.OrderItemsDAO;
import com.foodapp.daoConnect.DBConnection;
import com.foodapp.model.OrderItems;
import com.foodapp.model.Orders;

public class OrderItemsDAOimpl implements OrderItemsDAO
{
	ArrayList<OrderItems>orderitemslist=new ArrayList<OrderItems>();
	public final static String INSERTQUERY="insert into orderitems(OrderItemsId,OrderId,MenuId,Quantity,ItemTotal) values(?,?,?,?,?)";
	public final static String FETCHALL="select * from orderitems";
	public final static String FETCHONE="select * from orderitems where OrderItemsId=?";
	public final static String UPDATE="update orderitems set Quantity=? where OrderItemsId=?";
	public final static String DELETE="delete from orderitems where OrderItemsId=?";
	private static Connection con;
	
	
	static
	{
		con=DBConnection.connect();
	}


	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private OrderItems oi;


	@Override
	public int insert(OrderItems oi) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1, oi.getOrderItemsId());
			pstmt.setInt(2, oi.getOrderId());
			pstmt.setInt(3, oi.getMenuId());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setInt(5, oi.getItemTotal());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public ArrayList<OrderItems> fetchall() 
	{
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			orderitemslist=extractOrderItemsListFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderitemslist;
		
	}
	
	ArrayList<OrderItems> extractOrderItemsListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				orderitemslist.add(new OrderItems(
				resultSet.getInt("OrderItemsId"),
				resultSet.getInt("OrderId"),
				resultSet.getInt("MenuId"),
				resultSet.getInt("Quantity"),
				resultSet.getInt("ItemTotal")
				));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderitemslist;
	}


	@Override
	public OrderItems fetchone(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			orderitemslist=extractOrderItemsListFromResultSet(resultSet);
			oi=orderitemslist.get(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return oi;
	}


	@Override
	public int update(int quantity, int id) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(1,quantity);
			pstmt.setInt(2, id);
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
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
