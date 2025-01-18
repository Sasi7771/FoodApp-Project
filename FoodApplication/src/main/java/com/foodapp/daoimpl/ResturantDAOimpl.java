package com.foodapp.daoimpl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.ResturantDAO;
import com.foodapp.daoConnect.DBConnection;
import com.foodapp.model.Resturant;
import com.foodapp.model.User;

public class ResturantDAOimpl implements ResturantDAO
{
	ArrayList<Resturant> ResturantList=new ArrayList<Resturant>();
	public final static String INSERTQUERY="insert into resturant(ResturantId,Name,CuisineType,DeliveryTime,Address,Ratings,isActive,ImagePath) values(?,?,?,?,?,?,?,?)";
	public final static String FETCHALL="select * from resturant";
	public final static String FETCHONE="select * from resturant where ResturantId=?";
	public final static String UPDATE="update resturant set ImagePath=? where ResturantId=?";
	public final static String DELETE="delete from resturant where ResturantId=?";
	
	
	private static Connection con;

	static
	{
		con=DBConnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Resturant r;
	private String imagePath;

	@Override
	public int insert(Resturant r) 
	{
		try
		{
			FileInputStream	fis=new FileInputStream("D:/foodapp/images/barkath.png");
			
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1,r.getResturantId());
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setInt(4, r.getDeliveryTime());
			pstmt.setString(5, r.getAddress());
			pstmt.setFloat(6, r.getRatings());
			pstmt.setBoolean(7, r.isActive());
			pstmt.setBinaryStream(8, fis);
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<Resturant> fetchall() 
	{
		try
		{
			stmt=con.createStatement();	
			resultSet=stmt.executeQuery(FETCHALL);
			
			ResturantList=extracResturantListFromResultSet(resultSet);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResturantList;
	}
	
	
	
	ArrayList<Resturant> extracResturantListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				ResturantList.add(new Resturant(
				resultSet.getInt("ResturantId"),
				resultSet.getString("Name"),
				resultSet.getString("CuisineType"),
				resultSet.getInt("DeliveryTime"),
				resultSet.getString("Address"),
				resultSet.getFloat("Ratings"),
				resultSet.getBoolean("isActive"),
				resultSet.getString("ImagePath")
				));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResturantList;
	}

	@Override
	public Resturant fetchone(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
		    resultSet=pstmt.executeQuery();	
		    ResturantList=extracResturantListFromResultSet(resultSet);
		    r=ResturantList.get(0);
		    
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;

		
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





















