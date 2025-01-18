<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - Food Application</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            line-height: 1.6;
            color: #333;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1, h2 {
            color: #4a4a4a;
        }
        h1 {
            font-size: 24px;
            border-bottom: 2px solid #e0e0e0;
            padding-bottom: 10px;
            margin-top: 0;
        }
        h2 {
            font-size: 28px;
            margin-bottom: 20px;
            color: orange; /* Changed to orange */
        }
        form {
            display: grid;
            gap: 15px;
        }
        label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }
        input[type="text"], select {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: orange; /* Changed to orange */
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #ff8c00; /* Darker shade of orange for hover effect */
        }
        .section {
            margin-bottom: 30px;
        }
        @media (max-width: 480px) {
            .container {
                padding: 20px;
            }
        }
        select#paymentMethod {
            appearance: none;
            background-color: #f8f8f8;
            border: 2px solid #ddd;
            border-radius: 4px;
            padding: 10px 35px 10px 10px;
            font-size: 16px;
            color: #333;
            cursor: pointer;
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='%23333' viewBox='0 0 16 16'%3E%3Cpath d='M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z'/%3E%3C/svg%3E");
            background-repeat: no-repeat;
            background-position: calc(100% - 10px) center;
        }

        select#paymentMethod:hover, select#paymentMethod:focus {
            border-color: orange;
            outline: none;
        }

        select#paymentMethod option {
            background-color: #fff;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Checkout</h2>
        <form action="CheckoutServlet">
            <div class="section">
                <h1>Delivery Address</h1>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" required>
                
                <label for="houseno">House No</label>
                <input type="text" id="houseno" name="houseno" required>
                
                <label for="Area">Street/Area</label>
                <input type="text" id="Area" name="Area" required>
            </div>
            
            <div class="section">
                <h1>Payment Details</h1>
                <label for="paymentMethod">Payment Mode:</label>
                <select name="paymentMethod" id="paymentMethod">
                    <option value="PhonePe">PhonePe</option>
                    <option value="Gpay">Gpay</option>
                    <option value="Paytm">Paytm</option>
                    <option value="RazorPay">RazorPay</option>
                    <option value="NetBanking">Net Banking</option>
                    <option value="CreditCard">Credit Card</option>
                    <option value="DebitCard">Debit Card</option>
                    <option value="Cash">Cash On Delivery</option>
                </select>
            </div>
            
            <input type="submit" value="Place Order">
        </form>
    </div>
</body>
</html>

