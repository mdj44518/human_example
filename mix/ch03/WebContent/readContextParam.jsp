<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>초기화 파라미터 목록</h3>
	<ul>
	<%		
		Enumeration<String> params = application.getInitParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
	%>
		<li>
			<%= paramName %> : <%= application.getInitParameter(paramName) %>
		</li>
	<% } %>
	</ul>
	
</body>
</html>