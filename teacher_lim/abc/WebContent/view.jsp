<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String code = request.getParameter("code");
	String viewPageUrl = null;
	
	if (code.equals("A")) {
		viewPageUrl = "/viewModule/a.jsp";	
	} else if (code.equals("B")) {
		viewPageUrl = "/viewModule/b.jsp";
	} else if (code.equals("C")) {
		viewPageUrl = "/viewModule/c.jsp";
	}
	
	int[] names = {1, 2, 3, 4, 5};
	request.setAttribute("name", names);
%>
<body>
<jsp:forward page='<%= viewPageUrl %>' />
</body>
</html>