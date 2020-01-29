package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Student;

public class StudentDAO2 {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "devtester";
	private static final String password = "1234";
	private static Connection conn;
	
	public StudentDAO2() {
		
	}
	
	public static Connection getConnection() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, password);
			}
			
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean createUser(Student student) {
		return false;
	}
	
	public Student readUserFromId(String sId) {
		return null;
	}
	
	public Student readUserFromSNumber(String sNumber) {
		return null;
	}
}










