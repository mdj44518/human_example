package db_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQueryDemo {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "devtester";
	private static final String password = "1234";
	
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			
			Statement statement = con.createStatement();
			String sql = "insert into student " + 
					"values (\'서재호\', 7777, \'M\', \'서울시 관악구\', 100 )";
			/*
			int n = statement.executeUpdate(sql);
			if (n > 0) {
				System.out.println("데이터 추가 성공");
			}
			*/
			
			sql = "update student " + 
					"set address  = \'경기도 화성시 999\' " + 
					"where id = 1112";
			int n = statement.executeUpdate(sql);
			if (n > 0) {
				System.out.println("데이터 업데이트 성공");
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
