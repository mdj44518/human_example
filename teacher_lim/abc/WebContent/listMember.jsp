<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	boolean isLoggedIn = false;
	String id = null;
	String time = null;
	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if (c.getName() != null && c.getName().equals("id")) { 
			id = c.getValue();
			isLoggedIn = true;
		} else if (c.getName() != null && c.getName().equals("time")) { 
			time = c.getValue();
		}
	}
%>
<body>
<% if (isLoggedIn) { %>
<h2>로그인 성공</h2>
<h3>쿠기 타임: <%= time %></h3>
<h4><a href='logout.jsp'>로그아웃</a></h4>
<%} else { %>
<jsp:forward page="login.jsp">
	<jsp:param value="로그인 실패" name="error"/>
</jsp:forward>
<%} %>
</body>
</html>