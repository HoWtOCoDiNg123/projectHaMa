<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Registration</h1>
	<form action="register" method="post"> 
		<label for="username">Username:</label><br>
		<input type="text" id="username" name="username"><br><br>
		<label for="password">Password:</label><br>
		<input type="password" id="password" name="password"><br><br>	
		<label for="birthday">Birthday:</label><br>
		<input type="number" id="birthday" name="birthday"><br><br>
		<input type="submit" value="Submit">	
	</form>
</body>
</html>