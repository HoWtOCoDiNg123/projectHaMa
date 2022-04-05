<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<!-- 	send password and user name to server -> we need post method -->
	<h1>Login Form</h1> 
	<form action="login" method="post"> 
		<label for="username">Username:</label><br>
		<input type="text" id="username" name="username"><br><br>
		<label for="password">Password:</label><br>
		<input type="password" id="password" name="password"><br><br>
		<input type="submit" value="Submit"><br><br>
	</form>
	<h3>You don't have an account? Register now for free!</h3>
	<a href="register">Register</a>
</body>
</html>