<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id='member' scope="request" class='org.study.model.MemberInfo' />
<h3>아이디: ${member.id }</h3>
<h3>비밀번호: <jsp:getProperty property="password" name="member"/></h3>
<h3>이름: <jsp:getProperty property="name" name="member"/></h3>
<h3>가입일: <jsp:getProperty property="registerDate" name="member"/></h3>
<h3>이메일: <jsp:getProperty property="email" name="member"/></h3>
<h3>VIP: <jsp:getProperty property="bVip" name="member"/></h3>
</body>
</html>