<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>TEST Input</h1>
	
	<form action="/wsm/test/add" method="post">
		Name: <input type='text' name='name'> <br>
		지원부서:
		<select name='dept'>
			<option value='dev1'>개발1팀</option>
			<option value='dev2'>개발2팀</option>
			<option value='qa'>품질관리팀</option>
		</select> <br>
		보유기술: jsp/servlets<input type="checkbox" name="skills" value='jsp_servlet'>
		spring<input type="checkbox" name="skills" value='spring'>
		hibernate<input type="checkbox" name="skills" value='hibernate'>
		struts2<input type="checkbox" name="skills" value='strut'> <br>
		<input type='submit'>
		
	</form>
</body>
</html>