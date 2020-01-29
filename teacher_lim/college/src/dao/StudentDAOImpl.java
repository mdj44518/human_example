package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import model.Student;
import security.PasswordEncrypt;

public class StudentDAOImpl implements StudentDAO {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "devtester";
	private static final String password = "1234";
	private String salt = "QR1Hv71idxO1xpRS";
	
	public StudentDAOImpl() {
	}
	
	private Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 접근이 불가");
		}
		return null;
	}

	@Override
	public boolean createUser(Student student) {
		Connection con = getConnection();
		if (con != null) {
			try {
				// student number 생성
				String sql = "select studentnumseq.nextval from dual";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				int stuId = 0;
				while (rs.next()) {
					stuId = rs.getInt(1);
				}
				
				sql = "insert into student " + 
						"(sid, spw, sname, smajor, snumber, sBirthDate) values " 
						+ "(?, ?, ?, ?, ?, ?)";
				String sNum = student.getsMajor() + "-" + stuId;
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,student.getsId());
				String encryptedPw = PasswordEncrypt.generateSecurePassword(
						student.getsPw(), salt);
				stmt.setString(2, encryptedPw);
				stmt.setString(3, student.getsName());
				stmt.setInt(4, student.getsMajor());
				stmt.setString(5, sNum);
				stmt.setDate(6, student.getsBirthDateToDate());
				
				int result = stmt.executeUpdate();
				if (result > 0) {
					return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("사용자 등록 실패. 다시시도");;
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("데이터베이스 연결 해제 오류");
					}
				}
			}
		}
		return false;
	}

	@Override
	public Student readUserFromId(String sId) {
		Connection conn = getConnection();
		
		if (conn != null) {
			String sql = "select sname, smajor, snumber, sbirthdate"
					+ " from student "
					+ "where sid=?";
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, sId);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					Student s = new Student(sId, null);
					s.setsName(rs.getString(1));
					s.setsMajor(rs.getInt(2));
					s.setsNumber(rs.getString(3));
					Date birthDay = rs.getDate(4);
					// Date type --> LocalDate type
					LocalDate localDay = 
							new java.sql.Date(birthDay.getTime()).toLocalDate();
					s.setsBirthDate(localDay);
					
					return s;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public Student readUserFromSNumber(String sNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(Student student) {
		Connection conn = getConnection();
		
		if (conn != null) {
			String sql = "update student" + 
					" set sname=?, smajor=?, " + 
					" sbirthdate=?, spw=? " + 
					" where sid=?";
			String sqlWoPw = "update student" + 
					" set sname=?, smajor=?, " + 
					" sbirthdate=? " + 
					" where sid=?";
			try {
				PreparedStatement stmt = null;
				if (student.getsPw() != null) {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, student.getsName());
					stmt.setInt(2, student.getsMajor());
					stmt.setDate(3, java.sql.Date.valueOf(student.getsBirthDate()));
					String encryptedPw = PasswordEncrypt.generateSecurePassword(
							student.getsPw(), salt);
					stmt.setString(4, encryptedPw);
					stmt.setString(5, student.getsId());
				} else {
					stmt = conn.prepareStatement(sqlWoPw);
					stmt.setString(1, student.getsName());
					stmt.setInt(2, student.getsMajor());
					stmt.setDate(3, java.sql.Date.valueOf(student.getsBirthDate()));
					stmt.setString(4, student.getsId());
				}
				
				int result = stmt.executeUpdate();
				if (result > 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return false;
	}

	@Override
	public boolean deleteUser(String sId) {
		Connection con = getConnection();
		if (con != null) {
			String sql = "delete from student " + 
					"where sid = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, sId);
				int result = stmt.executeUpdate();
				
				if (result == 1) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				System.out.println("사용자 삭제 에러");;
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean existsUserId(String sId) {
		Connection con = getConnection();
		
		if (con != null) {
			String sql = "select sId from student " + 
					"where sid = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, sId);
				
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("사용자 아이디 중복체크 오류");;
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						System.out.println("데이터베이스 연결 해제 오류");
					}
				}
			}
		}
		
		// defensive approach: 
		// database connection를 얻지 못하면 무조건 해당 아이디가 존재하는 것으로
		// 답함
		return true;
	}

	@Override
	public boolean validateUser(String sId, String sPw) {
		Connection con = getConnection();

		if (con != null) {
			String sql = "select spw from student " + 
					"where sid=?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, sId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					String encryptedPw = rs.getString(1);
					if (PasswordEncrypt.verifyUserPassword(sPw, encryptedPw, salt)) {
						return true;
					} else {
						return false;
					}
				}
			} catch (SQLException e) {
				System.out.println("사용자 로그인 처리 에러");
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

}
