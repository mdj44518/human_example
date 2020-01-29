<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버쉽 가입페이지</title>
</head>
<body>
<form action='proc_join.jsp' method='post'>
	아이디: <input type='text' name='id' onkeyup='id_validate()'> <br>
	아이디확인: <input type='text' name='id_check'> <br>
	비밀번호: <input type='password' name= 'password'> <br>
	이름: <input type='text' name='name'> <br>
	이메일: <input type='email' name = 'email' > <br>
	<input type='submit' value='회원가입' >
</form>
</body>
<script>
	var mappingCodes = ['a', 'b', 'c', 'd', 'e'];
	var mappingTable = [1, 2, 3, 4, 5];
	
	
	function id_validate() {
		var converted = [];
		var idInput = document.querySelector('input[name=id]');
		var idArr = idInput.value.split("");
		
		for (var i = 0; i < idArr.length; i++) {
			for (var j = 0; j < mappingCodes.length; j++) {
				if (idArr[i] == mappingCodes[j]) {
					converted.push(mappingTable[j])
				}
			}
		}
		
		document.querySelector('input[name=id_check]').value = converted.join();
	}
	
	
</script>
</html>