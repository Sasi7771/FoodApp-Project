package com.foodapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.foodapp.dao.MenuDAO;
import com.foodapp.daoimpl.MenuDAOimpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet 
{
	
private MenuDAO mdao;


public void init()
{
	try
	{
		mdao=new MenuDAOimpl();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		int id = Integer.parseInt(req.getParameter("resturantId"));
		
		HttpSession session = req.getSession(false);
		
		if(session !=null && session.getAttribute("user")!=null)
		{
			try
			{
				session.removeAttribute("menuList");
				
				ArrayList<Menu> menuList = mdao.fetchMenuByResturant(id);
				
				session.setAttribute("menuList", menuList);
				
				resp.sendRedirect("menu.jsp");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				resp.sendRedirect("error.jsp");
			}
		}
		else
		{
			resp.sendRedirect("Login.html");
		}
		
	}
}
















