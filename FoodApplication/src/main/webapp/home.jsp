<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.foodapp.model.Resturant" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodDelivery</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            line-height: 1.6;
            background-color: #f0f0f0;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Navbar styles */
        .navbar {
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .navbar-content {
            display: flex;
            justify-content: space-between;
            align-items: center;
            height: 64px;
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
            color: #ff6600;
            text-decoration: none;
        }

        .nav-items {
            display: flex;
            align-items: center;
        }

        .nav-item {
            display: flex;
            align-items: center;
            color: #000000;
            text-decoration: none;
            margin-left: 24px;
            font-size: 14px;
        }

        .nav-item:hover {
            color: #ff6600;
        }

        .nav-item svg {
            margin-right: 4px;
        }

        /* Main content styles */
        .main-content {
            padding: 40px 0;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333333;
            font-size: 32px;
        }

        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 25px;
        }

        .restaurant-card {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.3s ease;
        }

        .restaurant-card:hover {
            transform: translateY(-5px);
        }

        .restaurant-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .restaurant-info {
            padding: 16px;
        }

        .restaurant-name {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 8px;
            color: #333333;
        }

        .restaurant-details {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 8px;
        }

        .rating {
            color: #ffa500;
            font-weight: bold;
        }

        .estimated-time {
            color: #666666;
            font-size: 14px;
        }

        .cuisine-chip {
            display: inline-block;
            background-color: #3498db;
            color: #ffffff;
            padding: 4px 8px;
            border-radius: 16px;
            font-size: 12px;
            margin-bottom: 8px;
        }

        .location {
            color: #666666;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="container">
            <div class="navbar-content">
                <a href="/" class="logo">FoodDelivery</a>
                <div class="nav-items">
                    <a href="/search" class="nav-item">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>
                        Search
                    </a>
                    <a href="/offers" class="nav-item">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M20.59 13.41l-7.17 7.17a2 2 0 0 1-2.83 0L2 12V2h10l8.59 8.59a2 2 0 0 1 0 2.82z"></path><line x1="7" y1="7" x2="7.01" y2="7"></line></svg>
                        Offers
                    </a>
                    <a href="/profile" class="nav-item">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg>
                        Profile
                    </a>
                    <a href="/cart" class="nav-item">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                        Cart
                    </a>
                    <a href="/logout" class="nav-item">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path><polyline points="16 17 21 12 16 7"></polyline><line x1="21" y1="12" x2="9" y2="12"></line></svg>
                        Logout
                    </a>
                </div>
            </div>
        </div>
    </nav>

    <main class="main-content">
        <div class="container">
            <h1>Restaurants near you</h1>
            <div class="restaurant-grid">
            
            <%
            
            ArrayList<Resturant> rlist= (ArrayList<Resturant>) session.getAttribute("resturantlist");
            
            if(rlist !=null && !rlist.isEmpty())
            {
            	
            	for(Resturant resturant : rlist)
            	{
           
            %>
            												
            <a href="MenuServlet?resturantId=<%= resturant.getResturantId() %>">
            
                <div class="restaurant-card">
                    <img src="  <%= resturant.getImagePath() %>" alt="<%=resturant.getName() %>" class="restaurant-image">
                    <div class="restaurant-info">
                        <h2 class="restaurant-name"><%= resturant.getName()%></h2>
                        <div class="restaurant-details">
                            <span class="rating">★★★★☆ 4.5</span>
                            <span class="estimated-time">25-35 min</span>
                        </div>
                        <div class="cuisine-chip"><%=resturant.getCuisineType() %></div>
                        <p class="location"><%= resturant.getAddress() %></p>
                    </div>
                </div>
                
                </a>
                
                <%
                
            	}
            }else{
            
                %>
                
                <div class="no restueants">
                <p>No resturants at this moment</p>
                </div>
                
                <% 
            } 
            %>
            </div>
          
        </div>
    </main>
</body>
</html>