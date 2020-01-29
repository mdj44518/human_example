<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String displayError = null;
	String logout = request.getParameter("logout");
	if (logout != null) {
		/*
		Cookie ck = new Cookie("user", "");
		ck.setMaxAge(0);
		response.addCookie(ck);
		*/
		session.invalidate();
		
		displayError = "성공적으로 로그아웃하였습니다.";
	}
	
	
	String error = (String)request.getAttribute("error");
	if (error != null) {
		displayError=error;
	}
%>

<%@ include file="/WEB-INF/views/common/begin.jspf"%>
<link href='<%=request.getContextPath() + "/css/login.css"%>'
	type='text/css' rel='stylesheet'>
<div class='container'>
	<h2>관리자 로그인</h2>
	
	<% if (displayError !=null) {%>
	<h4 class='error'><%= displayError %></h4>
	<%} %>
	<table>
		<form action='<%=request.getContextPath() + "/login"%>'
			method='post'>
		<tr>
			<td>아이디:</td>
			<td><input type='text' name='id' required></td>
		</tr>
		<tr>
			<td>비밀번호:</td>
			<td><input type="password" name='pw' required></td>
		</tr>
		<tr>
			<td></td>
			<td><input type='submit' value='로그인'></td>
		</tr>
		</form>
	</table>
</div>
<%@ include file="/WEB-INF/views/common/end.jspf"%>