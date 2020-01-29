package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.study.model.Student;
import org.study.model.StudentWN;

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
			stmt.setString(1, student.getsName());
			stmt.setString(2, student.getsId());
			stmt.setString(3, student.getEmail());
			stmt.setString(4, student.getAddress());
			stmt.setString(5,  student.getsPw());
			stmt.setDate(6, student.getBirthDay());
			stmt.setInt(7, student.getMajorCode());
			
			int result = stmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return false;
	}

	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public StudentWN[] getAllStudents() {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select sname, sid, address, email, birthday, mname " + 
					"from student, majordept " + 
					"where student.majorcode = majordept.mcode";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<StudentWN> list = new ArrayList<> ();
			while (rs.next()) {
				StudentWN s = new StudentWN();
				s.setsName(rs.getString(1));
				s.setsId(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setBirthDay(rs.getDate(5));
				s.setMajor(rs.getString(6));
				
				list.add(s);
			}
			
			return list.toArray(new StudentWN[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return null;
	}
	
	public boolean deleteStudent(String id) {
		Connection conn = getConnection();
		
		if (conn == null) {
			return false;
		}
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "delete from student where sid=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			int result = stmt.executeUpdate();
			
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return false;
	}

	public Student getStudentInfo(String id) {
		Connection conn = getConnection();
		
		if (conn == null) {
			return null;
		}
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select sname, sid, email, address, spw, birthday, majorcode"
				+ " from student where sid = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				Student s = new Student();
				s.setsName(rs.getString(1));
				s.setsId(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setsPw(rs.getString(5));
				s.setBirthDay(rs.getDate(6));
				s.setMajorCode(rs.getInt(7));
				
				return s;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return null;
	}

	public boolean updateStudent(Student student) {
		Connection conn = getConnection();
		
		if (conn == null) {
			return false;
		}
		
		PreparedStatement stmt = null;
		String sql = "update student " + 
				"set sname=?, email=?, address=?, "
				+ " spw=?, birthday=?, majorcode=?" 
				+ " where sid=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, student.getsName());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getAddress());
			stmt.setString(4, student.getsPw());
			stmt.setDate(5, student.getBirthDay());
			stmt.setInt(6, student.getMajorCode());
			stmt.setString(7, student.getsId());
			
			int result = stmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, null);
		}
		
		return false;
	}
}










