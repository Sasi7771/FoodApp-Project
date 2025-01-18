package com.foodapp.daoimpl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.foodapp.daoConnect.DBConnection;

public class Image 
{
	static String query="update resturant set ImagePath=? where ResturantId=?";
	private static Connection con;
	private static PreparedStatement pstmt;
	
	public static void main(String[] args) {
		
			try
			{
				int id=2;
				FileInputStream	fis=new FileInputStream("D:\\foodapp\\images\\mehfil.png");
				con=DBConnection.connect();
				
				pstmt=con.prepareStatement(query);
				
				pstmt.setInt(2, id);
				pstmt.setBinaryStream(1, fis);
				
				if(pstmt.executeUpdate()==1)
				{
					System.out.println("Sucess");
				}
				else
				{
					System.out.println("Failure");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		
	}
}
