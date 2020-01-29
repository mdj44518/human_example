<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
<jsp:include page='common/top.jsp' flush='false'>
	<jsp:param value='search' name='param1'/>
	<jsp:param value='10' name='highscore'/>
</jsp:include>
<h1>Main.jsp에 생성한 내용</h1>
<jsp:include page='common/bottom.jsp' flush='false' />
<h3>include이후의 내용</h3>
</body>
</html>