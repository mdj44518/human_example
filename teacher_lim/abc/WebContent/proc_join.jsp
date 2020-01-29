<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 처리 페이지</title>
</head>
<%
	Date regDate = new Date();
%>
<jsp:useBean id='member' scope="request" class='org.study.model.MemberInfo' />
<jsp:setProperty property="*" name="member" />
<jsp:setProperty property="registerDate" name="member" value='1999-05-01'/>
<%-- <jsp:setProperty property="registerDate" name="member" value='<%= regDate %>'/> --%>
<body>
<h1>회원가입 감사합니다.</h1>
<jsp:forward page='view_member.jsp' />

</body>
</html>