<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="member" scope="request" class='model.MemberInfo' />
<jsp:setProperty property='*' name='member'/>
<jsp:setProperty property="registerDate" name="member" value='1999-05-05'/>
<body>
<h1>회원가입 감사합니다.</h1>
<jsp:forward page="view_member.jsp" />

</body>
</html>