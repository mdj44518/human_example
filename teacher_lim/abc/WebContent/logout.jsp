<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if (c.getName() != null && c.getName().equals("id")) { 
			c.setMaxAge(0);
			response.addCookie(c);
		} 
	}
%>

<body>
<jsp:forward page='login.jsp' />
</body>
</html>