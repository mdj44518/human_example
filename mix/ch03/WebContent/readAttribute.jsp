<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Application attributes get</h3>
	<h4>Name : <%= request.getAttribute("name") %></h4>
	<h4>Email : <%= request.getAttribute("email") %></h4>
</body>
</html>