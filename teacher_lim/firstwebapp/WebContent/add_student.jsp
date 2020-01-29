<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생추가 페이지</title>
</head>
<%
	String reqChEncoding = request.getCharacterEncoding();
	//request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String gender = request.getParameter("gender");
%>
<body>
	<h1>더휴먼컴퓨터아트 아카데미</h1>
	<h3>회원 가입 감사합니다.</h3>
	
	<p>
		이름: <%= name %> <br>
		이메일: <%= email %> <br>
		주소: <%= address %> <br>
		성별: <%= gender %> <br>
	</p>
	<hr>
	<h6>캐릭터인코딩: <%= reqChEncoding %></h6>
</body>
</html>