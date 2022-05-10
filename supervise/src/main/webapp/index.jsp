<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Welcome to your personal profile, 
	<% 
   	HttpSession ses = request.getSession();
	User user =  (User) ses.getAttribute("logged_user");
	
	if(user != null){
		out.println(user.getUsername() + "!");
	}
	%>
	</h1>
	<h3>Your services:</h3>
	<a href="calculator">Calculator</a><br><br><br>
	<a href="logout">Logout</a>
</body>
</html>