package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.OrderHistoryDAO;
import com.foodapp.daoConnect.DBConnection;
import com.foodapp.model.OrderHistory;
import com.foodapp.model.OrderItems;

public class OrderHistoryDAOimpl implements OrderHistoryDAO
{
	ArrayList<OrderHistory>orderhistorylist=new ArrayList<OrderHistory>();
	public final static String INSERTQUERY="insert into orderhistory(OrderHistoryId,OrderId,UserId,TotalAmount,Status) values(?,?,?,?,?)";
	public final static String FETCHALL="select * from orderhistory";
	public final static String FETCHONE="select * from orderhistory where OrderHistoryId=?";
	public final static String UPDATE="update orderhistory set Status=? where OrderHistoryId=?";
	public final static String DELETE="delete from orderhistory where OrderHistoryId=?";
	private static Connection con;
	
	
	
	static
	{
		con=DBConnection.connect();
	}
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private OrderHistory oh;

	@Override
	public int insert(OrderHistory oh) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1, oh.getOrderHistoryId());
			pstmt.setInt(2, oh.getOrderId());
			pstmt.setInt(3, oh.getUserId());
			pstmt.setInt(4, oh.getTotalAmount());
			pstmt.setString(5, oh.getStatus());
	
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<OrderHistory> fetchall() 
	{
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			orderhistorylist=extractOrderHistoryListFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderhistorylist;
	}
	
	

	ArrayList<OrderHistory> extractOrderHistoryListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				orderhistorylist.add(new OrderHistory(
				resultSet.getInt("OrderHistoryId"),
				resultSet.getInt("OrderId"),
				resultSet.getInt("UserId"),
				resultSet.getInt("TotalAmount"),
				resultSet.getString("Status")
				));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderhistorylist;
	}

	@Override
	public OrderHistory fetchone(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			orderhistorylist=extractOrderHistoryListFromResultSet(resultSet);
			oh=orderhistorylist.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return oh;
	}

	@Override
	public int update(int id, String Status) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, id);
			pstmt.setString(1, Status);
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
