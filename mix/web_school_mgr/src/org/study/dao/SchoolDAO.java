package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.study.model.Student;

public class SchoolDAO {

	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String USER = "schoolmgr";
	private static final String PW = "1234";
	
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USER, PW);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean addStudent(Student student) {
		Connection conn = getConnection();
		
		if (conn == null) {
			return false;
		}
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into student " + 
				"(sname, sid, email, address, spw, birthday, majorcode) " + 
				"values " + 
				"(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return false;
	}

	private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
}










