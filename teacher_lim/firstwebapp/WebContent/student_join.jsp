<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록</title>
</head>
<%
	String name = request.getParameter("name");
	if (name == null) {
		name = "";
	}
	
	String email = request.getParameter("email");
	if (email == null) {
		email = "";
	}
	String address = request.getParameter("address");
	if (address == null) {
		address = "";
	}
	String gender = request.getParameter("gender");

%>

<body>
	<h1>학생 정보를 입력하세요</h1>

	<form action='' method='post'>
		<table>
			<tr>
				<td>이름:</td>
				<td><input type='text' name='name' value='<%= name %>'  required></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type='email' name='email' value='<%= email %>'></td>
			</tr>
			<tr>
				<td>주소:</td>
				<td><input type='text' name='address' value='<%= address %>'></td>
			</tr>
			<tr>
				<td>성별:</td>
				<td>
					<%
					if (gender == null) {
					%>
					<input type='radio' name='gender' value='male'>남자
					<input type='radio' name='gender' value='female'>여자
					<%
					} else {
						if (gender.equals("male")) { %>
	
					<input type='radio' name='gender' value='male' checked='checked'>남자
					<input type='radio' name='gender' value='female'>여자
					<% } else { %>
					 <input type='radio' name='gender' value='male'>남자
					 <input type='radio' name='gender' value='female' checked='checked'>여자
					
					<%
					   }
					}
					%>
					
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type='submit' value='가입'>
					<input type='reset' value='초기화'>
				</td>
			</tr>
		</table>
	</form>
	
	<hr>
	
	<p>
		이름: <%= name %> <br>
		이메일: <%= email %> <br>
		주소: <%= address %> <br>
		성별: <%= gender %> <br>
	</p>
</body>
</html>







