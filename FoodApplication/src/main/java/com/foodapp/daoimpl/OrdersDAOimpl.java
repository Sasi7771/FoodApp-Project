package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.OrdersDAO;
import com.foodapp.daoConnect.DBConnection;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

public class OrdersDAOimpl implements OrdersDAO
{
	ArrayList<Orders>orderslist=new ArrayList<Orders>();
	public final static String INSERTQUERY="insert into orders(OrderId,userid,resturantid,TotalAmount,Status,PaymentMode) values(?,?,?,?,?,?)";
	public final static String FETCHALL="select * from orders";
	public final static String FETCHONE="select * from orders where OrderId=?";
	public final static String UPDATE="update orders set PaymentMode=? where OrderId=?";
	public final static String DELETE="delete from orders where OrderId=?";
	private static Connection con;
	
	
	static
	{
		con=DBConnection.connect();
	}


	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Orders o;


	@Override
	public int insert(Orders o) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2,o.getUserid());
			pstmt.setInt(3, o.getResturantid());
			pstmt.setDouble(4, o.getTotalAmount());
			pstmt.setString(5, o.getStatus());
			pstmt.setString(6, o.getPaymentMode());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}


	@Override
	public ArrayList<Orders> fetchall() 
	{
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			orderslist= extractUserListFromResultSet(resultSet);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return orderslist;
	}
	
	ArrayList<Orders> extractUserListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				orderslist.add(new Orders(
				resultSet.getInt("OrderId"),
				resultSet.getInt("userid"),
				resultSet.getInt("resturantid"),
				resultSet.getInt("TotalAmount"),
				resultSet.getString("Status"),
				resultSet.getString("PaymentMode")
				));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderslist;
	}


	@Override
	public Orders fetchone(int id) 
	{
		try {
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			orderslist= extractUserListFromResultSet(resultSet);
			o=orderslist.get(0);
	     	} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return o;
	}


	@Override
	public int update(int id, String PaymentMode) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, id);
			pstmt.setString(1, PaymentMode);
			return pstmt.executeUpdate();
		}
		catch (Exception e) 
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





















