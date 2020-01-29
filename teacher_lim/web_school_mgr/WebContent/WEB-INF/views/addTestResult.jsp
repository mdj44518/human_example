<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>TEST Input Result</h1>
	
	<h3>이름: <%= request.getParameter("name") %></h3>
	<h3>부서: <%= request.getParameter("dept") %></h3>
	<h3>보유기술: <%= Arrays.toString(request.getParameterValues("skills")) %></h3>
	<hr>
	
	<h3>지원결과: 
	<% if (request.getAttribute("applyResult").equals("SUCCESS")) {%>
	 합격 축하! </h3>
	<% } else {%>
	다음에 지원해주세요. </h3>
	<%} %>
</body>
</html>