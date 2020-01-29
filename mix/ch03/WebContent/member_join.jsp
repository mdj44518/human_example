<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맴버쉽 가입페이지</title>
</head>
<body>
<form action='proc_join.jsp' method='post'>
	<fieldset>
	<legend>form form</legend>
		<ul style='list-style: none;'>
			<li>
				아이디 : <input type='text' name='id'>
			</li>
			<li>
				 비밀번호: <input type='password' name='password'>
			</li>
			<li>
				이름 : <input type='text' name='name'>
			</li>
			<li>
				이메일 : <input type='email' name='email'>
			</li>
		</ul>
		<input type='submit'>
	</fieldset>
</form>
</body>
</html>