<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmm");
	String strNow = format.format(now);
	if (pw.charAt(pw.length() - 1) == '$') {
		Cookie cookie = new Cookie("id", id);
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("time", strNow);
		cookie2.setMaxAge(30 * 60);
		response.addCookie(cookie2);
		
	}
%>
<body>
<a href='listMember.jsp'>회원조회</a>
</body>
</html>