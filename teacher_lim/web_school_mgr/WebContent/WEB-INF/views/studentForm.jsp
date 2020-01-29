<%@page import="java.sql.Date"%>
<%@page import="org.study.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String action = (String)request.getAttribute("action");
%>

<% if (action != null && action.equals("add")) {%>
<title>학생 추가 페이지</title>
<%} else { %>
<title>학생 정보 변경페이지</title>
<% } %>


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
<script>
	function validate() {
		var passwordInputs = document.querySelectorAll('input[type=password]');
		
		if (passwordInputs[0].value == passwordInputs[1].value) {
			console.log("same");
			return true;
		} else {
			alert('입력하신 비밀번호들이 일치하지 않습니다.');
			return false;
		}
	}
</script>
<div class='container'>
	<% if (action != null && action.equals("add")) {%>
	<h2>학생 추가</h2>
	<%} else { %>
	<h2>학생 정보 수정</h2>
	<%} %>
	<%
		if (errorCode != null && errorCode.equals("idDup")) {
	%>
	<div class='error'><h5>입력하신 아이디는 이미 사용중입니다. 다른 아이디를 고르세요</h5></div>
	<%} %>
	
	<% if (action != null && action.equals("add")) {%>
	<form action='<%= request.getContextPath() + "/student/add" %>' method="post">
	<%} else { %>
	<form action='<%= request.getContextPath() + "/student/update" %>' method="post">
	<%} %>
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
						<option value='305'>305 - 수학과</option>
						<option value='307'>307 - 통계학과</option>
						<option> -------------- </option>
						<option value='401'>401 - 전자공학과</option>
						<option value='402'>402 - 컴퓨터공학과</option>
						<option value='403'>403 - 정보공학과</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<% if (action != null && action.equals("add")) {%>
					<input type='submit' value="가입" onclick='return validate()'>
					<%} else { %>
					<input type='submit' value="수정" >
					<%} %>
					<input type='reset' value="초기화" >
				</td>
			</tr>
		</table>
	</form>
</div>
	
<%@ include file="./common/end.jspf" %>

<script>
	var majorCode = '<%= majorCode %>';
	
	// 한번에 해당 옵션을 요소를 찾는 방법?
	var options = document.querySelectorAll('option');
	//var option = document.querySelector('option[value=majorCode]');
	for (var i = 0; i < options.length; i++) {
		if (options[i].value == majorCode) {
			options[i].setAttribute('selected', true);
		}		
	}
	
	var action = '<%= action %>';
	if (action != undefined && action === 'update') {
		var idInput = document.querySelectorAll('input[type=text]')[1];
		idInput.setAttribute('readonly', true);
	}
	
	
</script>






