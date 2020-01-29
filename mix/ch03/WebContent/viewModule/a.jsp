<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int[] arr = (int[])request.getAttribute("name");
%>
<body>
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<br>
<%= Arrays.toString(arr).substring(1, Arrays.toString(arr).length() - 1)%>
</body>
</html>