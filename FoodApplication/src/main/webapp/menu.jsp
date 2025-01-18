<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.foodapp.model.Menu" %>
<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            margin: 0;
            color: #333;
        }
        .menu-item {
            display: flex;
            background-color: #ffffff;
            margin-bottom: 20px;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .item-details {
            flex: 1;
            padding: 20px;
        }
        .item-name {
            font-size: 20px;
            font-weight: bold;
            margin: 0 0 10px 0;
        }
        .item-rating {
            color: #ffa500;
            margin-bottom: 10px;
        }
        .item-description {
            color: #666;
            margin-bottom: 10px;
        }
        .item-price {
            font-weight: bold;
            font-size: 18px;
        }
        .item-image-container {
            width: 156px;
            position: relative;
        }
        .item-image {
            width: 156px;
            height: 144px;
            object-fit: cover;
        }
        .add-to-cart {
            background-color: #ff9800;
            color: white;
            border: none;
            padding: 5px 10px;
            font-size: 12px;
            border-radius: 4px;
            cursor: pointer;
            margin: 10px;
            transition: background-color 0.3s;
        }
        .add-to-cart:hover {
            background-color: #f57c00;
        }
        @media (max-width: 600px) {
            .menu-item {
                flex-direction: column;
            }
            .item-image-container {
                width: 100%;
            }
            .item-image {
                width: 100%;
                height: auto;
            }
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Available Items</h1>
        </div>
    </header>
    <main class="container">
    
    
    <% 
    ArrayList<Menu> mlist= (ArrayList<Menu>) session.getAttribute("menuList");
    
    if(mlist !=null && !mlist.isEmpty())
    {
    	
    	for(Menu menu : mlist)
    	{
    %>
    
        <div class="menu-item">
            <div class="item-details">
                <h2 class="item-name"><%= menu.getName() %></h2>
                <div class="item-rating">★★★★☆ 4.5</div>
                <p class="item-description"><%= menu.getDescription() %></p>
                <p class="item-price"> ₹<%= menu.getPrice()%>.00</p>
            </div>
            <div class="item-image-container">
                <img src="<%= menu.getImagePath() %>" alt="<%= menu.getName() %>" class="item-image">
                <form action="CartServlet">
                
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="itemId" value="<%= menu.getMenuId() %>">
                <button class="add-to-cart">Add to Cart</button>
                
                </form>
            </div>
        </div>
        
        <%
                
            	}
            }else{
            
                %>
                
                <div class="no restueants">
                <p>No Items Available at this moment</p>
                </div>
                
                <% 
            } 
            %>
        
       
        
        
        
    </main>
</body>
</html>