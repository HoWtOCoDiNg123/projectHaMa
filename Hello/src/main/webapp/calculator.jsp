<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Square-Calculator</h1>
	<form action="calculator" method="post">
		<input type="text" id="number_input" name="number_input">
		<input type="submit" value="Submit">
	</form>
	<% 
	String inputText = (String)request.getAttribute("input_text");
	Double result = null;
	try{
		result = Double.valueOf(inputText);
		result *= result;
	}
	catch(Exception e){
		out.println("You typed in " + inputText);
		return;
	}
	out.println(inputText +  " squared equals " + result);
	%>
</body>  
</html>