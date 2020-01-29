<%@page import="org.study.model.StudentWN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>학생 조회 페이지</title>

<%
	StudentWN[] students = (StudentWN[])request.getAttribute("students");
	String error = (String)request.getAttribute("error");
	
%>
<%@ include file="./common/begin.jspf"  %>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href='<%= request.getContextPath() + "/css/liststudent.css" %>' rel='stylesheet' type='text/css'>
	<div class="container">
		<%
		if (students == null) {
			if (error != null) {
		%>
			<h3>학생 삭제가 실패하였습니다.</h3>
		<%} %>
		
		<h3>학생 조회를 실패하였습니다. 다음에 이용해 주세요</h3>
		<%} else if (error != null){ %>
		
		<%} else { %>
		<h2>학생 조회</h2>
		<table>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>주소</th>
				<th>이메일</th>
				<th>생년월일</th>
				<th>전공학과</th>
				<th>비고</th>
			</tr>
			<% for (StudentWN s : students) { %>
			<tr>
				<td><%= s.getsName() %></td>
				<td><%= s.getsId() %></td>
				<td><%= s.getAddress() %></td>
				<td><%= s.getEmail() %></td>
				<td><%= s.getBirthDay() %></td>
				<td><%= s.getMajor() %></td>
				<td>
					<a href='<%= request.getContextPath() + "/student/delete?id=" + s.getsId() %>' >
						<i class="far fa-trash-alt"></i>
					</a> |
					<a href='<%= request.getContextPath() + "/student/update?id=" + s.getsId() %>' >
						<i class="far fa-edit"></i>
					</a>
				</td>
			</tr>
			<% } %>
		</table>
		<%} %>
	</div>
<%@ include file="./common/end.jspf" %>