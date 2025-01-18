package com.foodapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.foodapp.model.User;
import com.tap.myencrypts.Decrypt;
import com.tap.myencrypts.MyEncrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	
	String url="jdbc:mysql://localhost:3306/foodapplication";
	String dbus="root";
	String dbpw="sasi7781";
	private Connection con;
	
	private String CHECKEMAIL="select * from user where email=?";
	private PreparedStatement pstmt;
	private ResultSet res;
	private PrintWriter pw;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		User u=new User();
		HttpSession session = req.getSession();
		String email=MyEncrypt.encrypt(req.getParameter("email"));
		String password=MyEncrypt.encrypt(req.getParameter("password"));
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,dbus,dbpw);
			
			pstmt=con.prepareStatement(CHECKEMAIL);
			pstmt.setString(1, email);
			res=pstmt.executeQuery();
			
			
			
			
			if(res.next())
			{
				if(password.equals(res.getString("password")))
				{
					
					
					String name = res.getString("username");
	                email = res.getString("email");
	                String mobile = res.getString("mobile");
	                String address = res.getString("address");

	                // Set the actual userId in the session
	                int userId = res.getInt("userid");

	                // Create and set the User object and other session attributes
	                u.setUserid(userId);  // Ensure that the User object has the correct userId
	                session.setAttribute("user", u);
	                session.setAttribute("userId", userId); // Set the userId in session
	                session.setAttribute("name", Decrypt.decrypt(name));
	                session.setAttribute("email", Decrypt.decrypt(email));
	                session.setAttribute("mobile", Decrypt.decrypt(mobile));
	                session.setAttribute("address", Decrypt.decrypt(address));
					
					
					
					
					req.getRequestDispatcher("GetResturants").forward(req, resp);
				}
				else
				{
					resp.sendRedirect("PasswordMismatch.jsp");
				}
			}
			else
			{
				resp.sendRedirect("InvalidUser.jsp");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}


















//String name=res.getString("username");
//email=res.getString("email");
//String mobile=res.getString("mobile");
//String address=res.getString("address");
//
//Cookie ck1=new Cookie("email", email);
//
//resp.addCookie(ck1);
//
//session.setAttribute("user", u);
//
//session.setAttribute("userId", u.getUserid());
//session.setAttribute("name", u.getUsername());
//session.setAttribute("email", u.getEmail());
//session.setAttribute("address", u.getAddress());
//
//
//session.setAttribute("name", Decrypt.decrypt(name));
//session.setAttribute("email", Decrypt.decrypt(email));
//session.setAttribute("mobile", Decrypt.decrypt(mobile));
//session.setAttribute("address", Decrypt.decrypt(address));




//u = new User();
//u.setUserid(res.getInt("userid"));
//u.setUsername(Decrypt.decrypt(res.getString("username")));
//u.setEmail(Decrypt.decrypt(res.getString("email")));
//u.setAddress(Decrypt.decrypt(res.getString("address")));
//
//Cookie ck1 = new Cookie("email", u.getEmail());
//resp.addCookie(ck1);
//
//session.setAttribute("user", u);
//session.setAttribute("userId", u.getUserid());
//session.setAttribute("name", u.getUsername());
//session.setAttribute("email", u.getEmail());
//session.setAttribute("address", u.getAddress());







