<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Invalid User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .error-container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        .error-icon {
            font-size: 48px;
            color: #dc3545;
            margin-bottom: 1rem;
        }

        .error-title {
            color: #dc3545;
            font-size: 24px;
            margin-bottom: 1rem;
        }

        .error-message {
            color: #666;
            margin-bottom: 2rem;
            line-height: 1.5;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }

        .button {
            padding: 12px 24px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            transition: all 0.3s ease;
        }

        .login-button {
            background-color: #4CAF50;
            color: white;
        }

        .login-button:hover {
            background-color: #FFA500;
        }

        .register-button {
            background-color: #007bff;
            color: white;
        }

        .register-button:hover {
            background-color: #FFA500;
        }

        .divider {
            margin: 1rem 0;
            color: #666;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-icon">⚠️</div>
        <h1 class="error-title">Invalid User</h1>
        <p class="error-message">The email and password combination you entered is not registered.</p>
        
        <div class="button-container">
            <a href="Login.html" class="button login-button">Back to Login</a>
            
            <div class="divider">or</div>
            
            <a href="index.html" class="button register-button">Register as New User</a>
        </div>
    </div>
</body>
</html>