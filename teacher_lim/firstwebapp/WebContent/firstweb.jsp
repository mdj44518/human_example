<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Web App</title>
</head>
<body>
	<h1>First Web App</h1>
	<h4>Hello JSP</h4>
	
	<p>
		The time on the server is <%= new Date()%>
	</p>
</body>
</html>