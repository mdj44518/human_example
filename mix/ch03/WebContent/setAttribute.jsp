<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	if (name != null && email != null) {
		request.setAttribute("name", name);
		request.setAttribute("email", email);
// 		request.getRequestDispatcher("readAttribute.jsp").forward(request, response);
	
%>
		<jsp:forward page='readAttribute.jsp' />
<%
	}
%>
<body>
	<h3>Application attributes set</h3>
	<form>
	Name : <input type='text' name='name'><br>
	Email : <input type='email' name='email'>
	
	<input type='submit'>
	</form>
</body>
</html>