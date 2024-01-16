<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="pages/common/top-nav/TopNavigation.css">
</head>
<body>
	<nav class="top-nav">
        <div class="logo-container">
        	<div class="logo">YuyuChat</div>
        </div>
        <div class="link-container"><a href="#" onclick="onHome()">Home</a></div>
        <div class="link-container"><a href="#" onclick="onFeatures()">Features</a></div>
        <div class="link-container"><a href="#" onclick="onAboutUs()">About Us</a></div>
        <div class="link-container"><a href="#" onclick="onSignUp()">Sign Up</a></div>
        <div class="link-container login"><a href="#" onclick="onLogin()">Login</a></div>
    </nav>
    
    <script src="pages/common/top-nav/TopNavigation.js"></script>
</body>
</html>