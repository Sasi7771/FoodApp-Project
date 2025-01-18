<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <style>
        .overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.7);
            display: none;
            z-index: 1000;
        }

        .delivery-animation {
            position: fixed;
            bottom: 30%;
            left: -100px;
            z-index: 1001;
            display: none;
        }

        .bike-icon {
            font-size: 48px;
            color: orange;
        }

        .flag {
            position: absolute;
            right: -20px;
            top: -20px;
            color: #ff4444;
            transform-origin: bottom left;
        }

        @keyframes bikeRide {
            0% { transform: translateX(100vw); } /* Start from the right */
            100% { transform: translateX(-100vw); } /* End on the left */
        }

        @keyframes flagWave {
            0% { transform: rotate(-5deg); }
            100% { transform: rotate(5deg); }
        }

        .animate-bike {
            display: block;
            animation: bikeRide 4s linear forwards;
        }

        .animate-flag {
            animation: flagWave 0.5s ease-in-out infinite alternate;
        }

        .confirmation-message {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: white;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
            z-index: 1002;
            display: none;
        }

        .confirmation-message h3 {
            color: #4CAF50;
            margin: 0 0 10px 0;
        }
    </style>
</head>
<body onload="startAnimation()">
    <div class="overlay" id="overlay"></div>
    <div class="delivery-animation" id="deliveryAnimation">
        <span class="bike-icon">🚲</span>
        <span class="flag animate-flag">🚩</span>
    </div>
    <div class="confirmation-message" id="confirmationMessage">
        <h3>Order Confirmed!</h3>
        <p>Your delicious food is on the way</p>
    </div>

    <script>
        function startAnimation() {
            // Show overlay and animation
            document.getElementById('overlay').style.display = 'block';
            document.getElementById('deliveryAnimation').style.display = 'block';
            document.getElementById('confirmationMessage').style.display = 'block';
            document.getElementById('deliveryAnimation').classList.add('animate-bike');
        }
    </script>
</body>
</html>
