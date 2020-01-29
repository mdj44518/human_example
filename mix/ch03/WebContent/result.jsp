<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과</title>
</head>
<%
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String pets = Arrays.toString(request.getParameterValues("pet"));
%>
<body>
	<h1>설문조사 결과</h1>
	<p>
	이름 : <%= name %>
	<br>
	주소 : <%= address %>
	<br>
	좋아하는 동물 : <%= pets.substring(1, pets.length() -1) %>
	</p>
</body>
</html>