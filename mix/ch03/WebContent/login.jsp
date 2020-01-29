<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error {
		color: red;
	}
</style>
</head>
<%
	String error = request.getParameter("error");
	if (error == null) {
		error = "";
	}
%>
<body>
	<form action='proc_login.jsp' method='post'>
		<p id='message'><%=error%></p>
		아이디: <input type='text' name='id' required> <br>
		비밀번호: <input type='password' name='pw' required> <br>
		<input type='submit' value='로그인' onclick='return loginValid();'>
	</form>
</body>
<script>
	function loginValid(){
		var p = document.getElementById('message');
		// 아이디 값은 최소 6글자 이상
		var id = document.getElementsByTagName('input')[0];
		if (id.value.length < 6) {
			p.innerText = '아이디가 짧아요';
			p.textValue = '벨류와 차이가뭔가...';
			p.classList.add('error');
			return false;
		};
		// 비밀번호는 8글자 이상이고, 대문자를 최소 1개 이상 가져야되고....
		var pw = document.querySelector('input[type=password]');
		if (pw.value.length < 8){
			p.innerText = '비밀번호가 짧아요';
			p.classList.add('error');
			return false;
		}
		
		if (containsUpperCase(pw.value) == false){
			p.innerText = '특수문자가 없어요';
			p.classList.add('error');
			return false;
		}
		return true;
	}
	
	function containsUpperCase(str) {
		for (var i = 0; i < str.length; i++){
			if (str[i] == str[i].toUpperCase()){
				return true;
			}
		}
		return false;
	}
</script>
</html>