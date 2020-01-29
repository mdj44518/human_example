package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Student;
import security.PasswordEncrypt;

public class StudentDAOImpl implements StudentDAO {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "devtester";
	private static final String password = "1234";
	private String salt;
	
	public StudentDAOImpl() {
		salt = PasswordEncrypt.getSalt(16);
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
				PreparedStatement stmt = con.prepareCall(sql);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student readUserFromSNumber(String sNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(Student student) {
		// TODO Auto-generated method stub
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
			}
		}
		
		return false;
	}

}
