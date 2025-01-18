package com.foodapp.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tap.myencrypts.MyEncrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class CollectData extends HttpServlet
{
	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String username=MyEncrypt.encrypt(req.getParameter("username"));
		String email=MyEncrypt.encrypt(req.getParameter("email"));
		String mobile=MyEncrypt.encrypt(req.getParameter("mobile"));
		String address=MyEncrypt.encrypt(req.getParameter("address"));
		String password=MyEncrypt.encrypt(req.getParameter("password"));
		
		String INSERT="insert into user(username,email,mobile,address,password) values(?,?,?,?,?)";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapplication","root","sasi7781");
			
			pstmt=con.prepareStatement(INSERT);
			
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			pstmt.setString(3, mobile);
			pstmt.setString(4, address);
			pstmt.setString(5, password);
			
			int x=pstmt.executeUpdate();
			
			if(x==1)
			{
				resp.sendRedirect("Login.html");
			}
			else
			{
				resp.sendRedirect("Failure.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
