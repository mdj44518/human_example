<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String param = request.getParameter("param1");
	int highScore = Integer.parseInt(request.getParameter("highscore"));
%>
<body>
<h2>top.jsp에서 생성된 내용</h2>
<h3>param: <%= param %></h3>
<h3>high score: <%=highScore %></h3>
</body>
</html>