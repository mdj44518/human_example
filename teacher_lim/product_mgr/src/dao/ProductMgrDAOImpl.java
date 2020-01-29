package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import model.Product;
import model.ProductType;
import model.Supplier;

public class ProductMgrDAOImpl implements ProductMgrDAO {

	private static final String URL = "jdbc:oracle:thin:@192.168.60.152:1521:xe";
	private static final String USER = "devtester";
	private static final String PASSWORD = "1234";
	
	private static BasicDataSource dataSource;
	
	private Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		
		return null;
	}
	
	private void close(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private BasicDataSource getDataSource() {
		if (dataSource == null) {
			BasicDataSource ds = new BasicDataSource();
			ds.setUrl("jdbc:oracle:thin:@192.168.60.152:1521:xe");
			ds.setUsername(USER);
			ds.setPassword(PASSWORD);
			
			ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);
 
            dataSource = ds;
		}
		
		return dataSource;
	}
	
	@Override
	public Product[] getAllProductInfo() {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null) {
			return null;
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql ="select * from Product";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<Product> list = new ArrayList<> ();
			while (rs.next()) {
				String name = rs.getString(1);
				String code = rs.getString(2);
				int firstQ = rs.getInt(3);
				int secondQ = rs.getInt(4);
				int thirdQ = rs.getInt(5);
				int fourthQ = rs.getInt(6);
				String supCode = rs.getString(7);
				
				Product p = new Product();
				p.setpName(name);
				p.setpCode(code);
				p.setFirstQ(firstQ);
				p.setSecondQ(secondQ);
				p.setThirdQ(thirdQ);
				p.setFourthQ(fourthQ);
				p.setSupCode(supCode);
				
				list.add(p);
			}
			
			return list.toArray(new Product[0]);
		} catch (SQLException e) {
			System.out.println("All product query failed");
		} finally {
			close(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public Product[] getProductInfoFromPName(String pName) {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null) {
			return null;
		}
		
		String sql = "select code, firstQ, secondQ, thirdQ, fourthQ"
				+ " from product " + 
				"where name=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pName);
			rs = stmt.executeQuery();
			List<Product> list = new ArrayList<> ();
			while (rs.next()) {
				Product p = new Product();
				p.setpCode(rs.getString(1));
				p.setFirstQ(rs.getInt(2));
				p.setSecondQ(rs.getInt(3));
				p.setThirdQ(rs.getInt(4));
				p.setFourthQ(rs.getInt(5));
				
				list.add(p);
			}
			
			return list.toArray(new Product[0]);
		} catch (SQLException e) {
			System.out.println("get product info from product name failed");;
		} finally {
			close(conn, stmt, rs);
		}
		
		return null;
	}

	//
	//
	@Override
	public int getYearlySalesFromPCode(String pCode) {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "select code, firstq + secondq+thirdq+fourthq " + 
				"from product " + 
				"where code=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pCode);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				String code = rs.getString(1);
				int sum = rs.getInt(2);
				
				return sum;
			} else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return -1;
	}

	@Override
	public String getSupplierNameFromPCode(String pCode) {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null) {
			return null;
		}
		
		String sql = "select  name " + 
				"from supplier " + 
				"where code = (select sup_code " + 
				"from product " + 
				"where code=?)";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pCode);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("상품 제조사 조회 실패");;
		} finally {
			close(conn, stmt, rs);
		}
		
		return null;
		
		/* 두번의 쿼리로 수행 
		String sql = "select sup_code " + 
				"from product " + 
				"where code=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, pCode);
			String supCode = null;
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				supCode = rs.getString(1);
			} else {
				return null;
			}
			
			sql = "select  name " + 
					"from supplier " + 
					"where code = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, supCode);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("제조사 조회 실패");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		*/
	}

	@Override
	public boolean addProduct(Product product) {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null && product == null) {
			return false;
		}
		
		ProductType[] pTypes = ProductType.values();
		ProductType pType = null;
		for (ProductType p : pTypes) {
			if (p.getProductName().equals(product.getpName())) {
				pType = p; 
			}
		}
		
		if (pType == null) {
			return false;
		}
		
		String productPrefix = pType.toString() + "-";
		
		String productCode = productPrefix + getPCodeNextValue(pType.toString()); 
		
		String sql = "insert into product " + 
				"(name, code, firstq, secondq, thirdq, "
				+ "fourthq, sup_code) " + 
				"values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getpName());
			stmt.setString(2, productCode);
			stmt.setInt(3, product.getFirstQ());
			stmt.setInt(4, product.getSecondQ());
			stmt.setInt(5, product.getThirdQ());
			stmt.setInt(6, product.getFourthQ());
			stmt.setString(7, product.getSupCode());
			
			int result = stmt.executeUpdate();
			if (result > 0) {
				System.out.println("상품 추가 성공");
			} else {
				System.out.println("상품 추가 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("상품 추가 에러 발생");;
		} finally {
			close(conn, stmt, null);
		}
		
		return false;
	}

	private int getPCodeNextValue(String pCodePrefix) {
		String sql1 = "select ";
		String sql2 = "CODESEQ.nextval from dual";
		
		String sql = sql1 + pCodePrefix + sql2;
		
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		
		return -2;
	}

	@Override
	public boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Supplier[] getAllSuppliers() {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null) {
			return null;
		}
		
		List<Supplier> list = new ArrayList<> ();
		String sql = "select * from supplier";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Supplier s = new Supplier();
				s.setsCode(rs.getString(1));
				s.setsName(rs.getString(2));
				list.add(s);
			}
			
			return list.toArray(new Supplier[0]);
		} catch (SQLException e) {
			System.out.println("공급자 리스트 조회 실패");
		} finally {
			close(conn, stmt, rs);
		}
		
		return null;
	}

	@Override
	public String getMaxPCodefromPName(String pName) {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null) {
			return null;
		}
		
		String sql = "select max(code) " + 
				"from product " + 
				"group by name " + 
				"having name=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pName);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("최대 상품코드 쿼리 에러");;
		} finally {
			close(conn, stmt, rs);
		}
		
		return null;
	}

	@Override
	public String[] getAllSupplierCodes() {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null) {
			return null;
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select code from supplier";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<String> list = new ArrayList<> ();
			while (rs.next()) {
				String code = rs.getString(1);
				list.add(code);
			}
			
			return list.toArray(new String[0]);
		} catch (SQLException e) {
			System.out.println("모든 공급업체 코드 쿼리 에러");;
		} finally {
			close(conn, stmt, rs);
		}
		
		return null;
	}

	@Override
	public String[] getAllCatSupplierCodesFromPName(String pName) {
		//Connection conn = getConnection();
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (conn == null) {
			return null;
		}
		
		String sql = "select code " + 
				"from supplier " + 
				"where category = (select category " + 
				"from supplier " + 
				"where code = (select max(sup_code) " + 
				"from product " + 
				"where name = ? " + 
				"group by name))";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pName);
			List<String> list = new ArrayList<> ();
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			
			return list.toArray(new String[0]);
		} catch (SQLException e) {
			System.out.println("특정 제품 공급업체 코드 쿼리 에러");;
		} finally {
			close(conn, stmt, rs);
		}
		
		return null;
	}

	@Override
	public ResultSet processQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}





