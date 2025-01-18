package com.foodapp.servlet;

import java.io.IOException;

import com.foodapp.dao.MenuDAO;
import com.foodapp.daoimpl.MenuDAOimpl;
import com.foodapp.model.Cart;
import com.foodapp.model.CartItem;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null)
		{
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		
		String action = req.getParameter("action");
		MenuDAO menuDAO = null;
		try
		{
			menuDAO=new MenuDAOimpl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			int itemId=Integer.parseInt(req.getParameter("itemId"));
			
			if(action.equals("add"))
			{
				Menu menuItem = menuDAO.fetchone(itemId);
				if(menuItem != null)
				{
					int quantity=1;
					CartItem  cartItem=new CartItem(
							menuItem.getMenuId(),
							menuItem.getResturantId(),
							menuItem.getName(),
							quantity,
							menuItem.getPrice()
							);
					cart.addItem(cartItem);
				}
			}
			else if("update".equals(action))
			{
				int quantity = Integer.parseInt(req.getParameter("quantity"));
				cart.updateItem(itemId, quantity);
			}
			else if("remove".equals(action))
			{
				cart.removeItem(itemId);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
	}
}
















