package db_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoApp {

	public static void main(String[] args) {
		// 데이터베이스 시스템으로 접근하는 스텝
		
		Connection con = null;
		try {
			// 1. Driver class 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 객체를 얻어야 함.
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"DEVTESTER", "1234");
			
			//System.out.println(con);
			// 3. 쿼리를 수행할 수 있는 Statement 객체 생성 
			Statement stmt = con.createStatement();
			
			// 4. 쿼리를 수행
			ResultSet result = stmt.executeQuery("select *"
					+ " from student");
			
			// 5. ResultSet 객체에서 정보를 추출
			while (result.next()) {
				String name = result.getString(1);
				int id = result.getInt(2);
				char gender = result.getString(3).charAt(0);
				String address= result.getString(4);
				
				System.out.println("Name: " + name);
				System.out.println("ID: " + id);
				System.out.println("GENDER: " + gender);
				System.out.println("Address: " + address);
				System.out.println();
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
