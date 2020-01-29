<%@page import="java.sql.Date"%>
<%@page import="org.study.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>학생추가페이지</title>
<%@ include file="./common/begin.jspf" %>
<link href='<%= request.getContextPath() + "/css/addstudent_style.css"%>' rel='stylesheet' type='text/css'>
<%
	String errorCode = (String)request.getAttribute("errorCode");

	String sName = "";
	String sId = "";
	String email = "";
	String address= "";
	String birthDay = "";
	String majorCode = "";

	Student student = (Student)request.getAttribute("student");
	if (student != null) {
		sName = student.getsName() == null ? "" : student.getsName();
		sId = student.getsId() == null ? "" : student.getsId();
		email = student.getEmail() == null ? "" : student.getEmail();
		address= student.getAddress() == null ? "" : student.getAddress();
		birthDay = student.getBirthDay() == null ? "" : student.getBirthDay().toString();
		majorCode = student.getMajorCode() == 0 ? "" : String.valueOf(student.getMajorCode());
	}
%>
<div class='container'>
	<h2>학생 추가</h2>
	
	<%
		if (errorCode != null && errorCode.equals("idDup")) {
	%>
	<div class='error'><h5>입력하신 아이디는 이미 사용중입니다. 다른 아이디를 고르세요</h5></div>
	<%} %>
	<form action='<%= request.getContextPath() + "/student/add" %>' method="post">
		<table>
			<tr>
				<td>이름(*): </td>
				<td><input type='text' name='sname' value='<%= sName %>' required></td>
			</tr>
			<tr>
				<td>아이디(*): </td>
				<td>
					<input type='text' name='sid' value='<%= sId %>' required>
				</td>
			</tr>
			<tr>
				<td>비빌번호(*): </td>
				<td><input type='password' name='spw' ></td>
			</tr>
			<tr>
				<td>비밀번호 확인(*): </td>
				<td><input type='password' name='spw2' ></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><input type='email' name='email' value='<%= email %>'></td>
			</tr>
			<tr>
				<td>주소: </td>
				<td><input type='text' name='address' value='<%= address %>'></td>
			</tr>
			<tr>
				<td>생년월일: </td>
				<td><input type='date' name='birthday' value='<%= birthDay %>'></td>
			</tr>
			<tr>
				<td>전공학과: </td>
				<td>
					<select name="majorcode">
						<% if (majorCode.equals("305")) { %>
						<option value=305 selected>305 - 수학과</option>
						<% } else { %>
						<option value=305>305 - 수학과</option>
						<% }%>
						<% if (majorCode.equals("307")) { %>
						<option value=307 selected>307 - 통계학과</option>
						<% } else { %>
						<option value=307>307 - 통계학과</option>
						<% }%>

						<option> -------------- </option>
						<option value=401>401 - 전자공학과</option>
						<option value=402>402 - 컴퓨터공학과</option>
						<option value=403>403 - 정보공학과</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type='submit' value="가입" >
					<input type='reset' value="초기화" >
				</td>
			</tr>
		</table>
	</form>
</div>
	
<%@ include file="./common/end.jspf" %>