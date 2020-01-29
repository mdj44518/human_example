<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A 페이지</title>
</head>
<%
	int[] arr = (int[])request.getAttribute("name");
%>
<body>
이 페이지는 <b>A</b> 페이지 입니다.

<ul>
<% for (int i = 0; i < arr.length; i++) {%>
	<li><%= arr[i] %></li>
<%} %>
</ul>
</body>
</html>