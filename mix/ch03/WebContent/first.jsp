<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML 문서의 제목</title>
</head>
<body>
<%
	String bookTitle = "JSP 프로그래밍";
	String autor = "최범균";
	Calendar cal = Calendar.getInstance();
%>

<b><%= bookTitle %></b>(<%= "\"크크크\"" %>)입니다.
<p style='color: yellow;'>
현재시간 : <%= new Date() %>
</p>
<p>
오늘은 <%= cal.get(Calendar.YEAR) %>년 
	<%= cal.get(Calendar.MONTH) + 1 %>월
	<%= cal.get(Calendar.DAY_OF_MONTH) %>일 입니다.
</p>
<input type='submit' >
</body>
</html>

<script>
var col = document.querySelector('p').style;
	setInterval(function() {
		if (col.color == 'pink'){
		}
	}, 500);
	
	setInterval(function() {
		<% %>
		if (col.color == 'yellow'){
			col.color = 'red';
		} else if (col.color == 'red'){
			col.color = 'pink';
		} else {
			col.color = 'yellow';
		}
	}, 3000);
</script>