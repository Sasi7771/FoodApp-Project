<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Mismatch</title>
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

        .back-button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #FFA500;
        }

        .shake {
            animation: shake 0.5s ease-in-out;
        }

        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            25% { transform: translateX(-10px); }
            75% { transform: translateX(10px); }
        }
    </style>
</head>
<body>
    <div class="error-container shake">
        <div class="error-icon">❌</div>
        <h1 class="error-title">Password Incorrect</h1>
        <p class="error-message">The password you entered is incorrect. Please try again.</p>
        <a href="Login.html" class="back-button">Back to Login</a>
    </div>

    <script>
        // Remove shake class after animation completes to allow it to be re-applied
        document.querySelector('.error-container').addEventListener('animationend', function() {
            this.classList.remove('shake');
        });
    </script>
</body>
</html>