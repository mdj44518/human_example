<%@page import="java.util.ArrayList"%>
<%@page import="org.study.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	final String url = "jdbc:oracle:thin:@//127.0.0.1:1521/xe";
	final String user = "devtester";
	final String password = "1234";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url, user, password);
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "select sname, smajor, sbirthdate "
			+ "from student";
	List<Student> list = null;
	if (conn != null) {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		list = new ArrayList<> ();
		while (rs.next()) {
			Student s = new Student();
			s.setName(rs.getString(1));
			s.setNumber(rs.getInt(2));
			s.setBirthDay(rs.getDate(3));
			
			list.add(s);
		}
	}
%>
<body>
	<h1>학생 리스트</h1>
	
	<table border=1>
		<tr>
			<th>이름</th>
			<th>전공</th>
			<th>생년월일</th>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<th><%= list.get(i).getName() %></th>
			<th><%= list.get(i).getNumber() %></th>
			<th><%= list.get(i).getBirthDay() %></th>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>