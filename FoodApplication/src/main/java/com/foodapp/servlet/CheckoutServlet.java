package com.foodapp.servlet;

import java.io.IOException;

import com.foodapp.daoimpl.OrdersDAOimpl;
import com.foodapp.model.Cart;
import com.foodapp.model.CartItem;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet 
{
	

	private OrdersDAOimpl ordersDAO;

	@Override
	public void init()
	{
		try
		{
			ordersDAO=new OrdersDAOimpl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			HttpSession session = req.getSession();
			Cart cart =  (Cart) session.getAttribute("cart");
			User user = (User) session.getAttribute("user");
			
			
			
		
			
			if(cart != null && user != null && !cart.getItems().isEmpty())
			{
				String paymentMethod = req.getParameter("paymentMethod");
				
				Orders orders=new Orders();
				
				orders.setUserid((int)session.getAttribute("userId"));
				orders.setResturantid((int)session.getAttribute("resturantId"));
				orders.setPaymentMode(paymentMethod);
				orders.setStatus("Pending");
				 
				double totalAmount=0;
				for(CartItem item : cart.getItems().values())
				{
					totalAmount += item.getPrice() * item.getQuantity();
				}
				orders.setTotalAmount(totalAmount);
				
				ordersDAO.insert(orders);
				
				session.removeAttribute("cart");
				session.setAttribute("orders", orders);
				
				resp.sendRedirect("order_confirmation.jsp");
								  
			}
			else
			{
				resp.sendRedirect("home.jsp");
			}
		}
}
