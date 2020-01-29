<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>학생 추가 폼</title>
<link href=<%= request.getContextPath() + "/css/style.css" %> rel='stylesheet' type='text/css'>
<link href=<%= request.getContextPath() + "/css/addstudent_style.css" %> rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Stylish" rel="stylesheet">
</head>
<body>
	<h1>The Human College</h1>
	<nav>
		<a href="#" >학생추가</a>
		<a href="#" >학생조회</a>
		<a href="#">학생정보변경</a>
		<a href="#" id='navright'>로그인</a>
	</nav>
	<h2>학생 추가</h2>
	
	<form action='<%= request.getContextPath() + "/student/add" %>' method="post">
		<table>
			<tr>
				<td>이름(*): </td>
				<td><input type='text' name='sname' required></td>
			</tr>
			<tr>
				<td>아이디(*): </td>
				<td>
					<input type='text' name='sid' required>
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
				<td><input type='email' name='email' ></td>
			</tr>
			<tr>
				<td>주소: </td>
				<td><input type='text' name='address' ></td>
			</tr>
			<tr>
				<td>생년월일: </td>
				<td><input type='date' name='birthday' ></td>
			</tr>
			<tr>
				<td>전공학과: </td>
				<td>
					<select name="majorcode">
						<option value=305>305 - 수학과</option>
						<option value=307>307 - 통계학과</option>
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
	<footer>
		<h3>The HUMAN COLLEGE Copyright&copy; 2019, 사람이 먼저다.</h3>
	</footer>
</body>
</html>