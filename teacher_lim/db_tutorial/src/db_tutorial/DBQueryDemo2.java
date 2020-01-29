package db_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQueryDemo2 {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "devtester";
	private static final String password = "1234";
	
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			String sql = "update student " + 
					"set address  = ? " + 
					"where id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			
			// 사용자로부터 학생아이디, 주소를 입력받는다..
			String address = "충청북도 청주시 123";
			int sId = 1112;
			statement.setString(1, address);
			statement.setInt(2, sId);
			
			int n = statement.executeUpdate();
			if (n > 0) {
				System.out.println("정보수정 성공");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
