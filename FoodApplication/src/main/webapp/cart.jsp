<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.foodapp.model.Cart" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.foodapp.model.CartItem" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart | Food Delivery App</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            color: #333;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            padding: 10px 0;
        }
        h1 {
            text-align: center;
            color: #fc8019;
        }
        .cart-container {
            display: flex;
            flex-direction: column;
            margin-top: 20px;
        }
        .cart-items {
            background-color: #fff;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
        }
        .cart-summary {
            background-color: #fff;
            border-radius: 8px;
            padding: 20px;
        }
        .cart-item {
            display: flex;
            flex-direction: column;
            border-bottom: 1px solid #eee;
            padding: 15px 0;
        }

        .item-details {
            margin-bottom: 15px;
        }
        .item-quantity {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .quantity-controls {
            display: flex;
            align-items: center;
            margin-right: 15px;
        }
        .quantity-btn {
            background-color: #fc8019;
            color: #fff;
            border: none;
            font-size: 18px;
            width: 30px;
            height: 30px;
            border-radius: 50%;
            cursor: pointer;
            margin: 0 5px;
        }
        .quantity-btn:hover {
            background-color: #e67300;
        }
        .remove-btn {
            background-color: #ff4d4d;
            color: #fff;
            border: none;
            font-size: 14px;
            padding: 5px 10px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .remove-btn:hover {
            background-color: #ff1a1a;
        }
        .item-price {
            font-weight: bold;
        }
        .summary-item {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }
        .checkout-btn, .add-more-btn {
            display: block;
            width: 100%;
            padding: 15px;
            color: #fff;
            text-align: center;
            text-decoration: none;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            margin-top: 20px;
            cursor: pointer;
            background-color: #fc8019;
        }
        .add-more-btn:hover, .checkout-btn:hover {
            background-color: #e67300;
        }
        @media (min-width: 768px) {
            .cart-container {
                flex-direction: row;
            }
            .cart-items {
                flex: 2;
                margin-right: 20px;
                margin-bottom: 0;
            }
            .cart-summary {
                flex: 1;
            }
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Your Cart</h1>
        </div>
    </header>

    <main class="container">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null || cart.getItems().isEmpty()) {
        %>
        <div class="empty-cart">
            <p>Your cart is empty.</p>
            <a href="menu.jsp" class="add-more-btn">Browse Restaurants</a>
        </div>
        <%
            } else {
                int restaurantId = 0;
                if(!cart.getItems().isEmpty()) {
                    restaurantId = cart.getItems().values().iterator().next().getResturantId();
                    session.setAttribute("resturantId", restaurantId);
                }
        %>
        <div class="cart-container">
            <section class="cart-items">
                <h2>Cart Items</h2>
                <%
                    double totalAmount = 0;
                    CartItem firstItem = null;
                    for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                        CartItem item = entry.getValue();
                        totalAmount += item.getPrice() * item.getQuantity();
                %>
                <div class="cart-item">
                    <div class="item-details">
                        <h3><%= item.getName() %></h3>
                        <p>Hyderabadi Style</p>
                    </div>
                    <div class="item-quantity">
                        <form action="CartServlet" class="quantity-controls">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>" class="quantity-btn" aria-label="Decrease quantity">-</button>
                            <span><%= item.getQuantity() %></span>
                            <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>" class="quantity-btn" aria-label="Increase quantity">+</button>
                        </form>
                        <form action="CartServlet">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <button type="submit" class="remove-btn">Remove</button>
                        </form>
                    </div>
                    <div class="item-price">
                        <p>₹ <%= item.getPrice() * item.getQuantity() %></p>
                    </div>
                </div>
                <%
                    }
                %>
                <!-- Single Add More Items button outside the loop -->
               
                    <a href="MenuServlet?resturantId=<%= session.getAttribute("resturantId") %>" class="add-more-btn">Add More Items</a>
                
            </section>

            <section class="cart-summary">
                <h2>Order Summary</h2>
                <div class="summary-item">
                    <span>Subtotal</span>
                    <span>₹ <%= totalAmount %></span>
                </div>
                <div class="summary-item">
                    <span>Delivery Fee</span>
                    <span>₹40</span>
                </div>
                <div class="summary-item">
                    <span>Taxes</span>
                    <span>₹44.30</span>
                </div>
                <hr>
                <div class="summary-item">
                    <strong>Total</strong>
                    <strong>₹ <%= totalAmount + 40 + 44.30 %></strong>
                </div>
                <a href="checkout.jsp" class="checkout-btn">Proceed to Checkout</a>
            </section>
        </div>
        <%
            }
        %>
    </main>
</body>
</html>