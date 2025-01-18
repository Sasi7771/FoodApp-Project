package com.foodapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.dao.ResturantDAO;
import com.foodapp.daoimpl.ResturantDAOimpl;
import com.foodapp.model.Resturant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetResturants
 */
public class GetResturants extends HttpServlet 
{
	private ArrayList<Resturant> resturantlist;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Cookie[] cookie = req.getCookies();
		if(cookie[0].getValue()!=null)
		{
			ResturantDAO rdao=new ResturantDAOimpl();
			
			resturantlist=rdao.fetchall();
			
			HttpSession session = req.getSession();
			
			session.setAttribute("resturantlist", resturantlist);
			
			resp.sendRedirect("home.jsp");
		}
		else
		{
			resp.sendRedirect("Login.html");
		}
	}
}














