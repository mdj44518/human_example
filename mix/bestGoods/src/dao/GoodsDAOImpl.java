package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import model.Company;
import model.Goods;

public class GoodsDAOImpl implements GoodsDAO {
	
	public enum List {
		GNAME, GCODE, Q1_SELLING, Q2_SELLING, Q3_SELLING, Q4_SELLING, COMPANYCODE
	}
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "goods";
	private static final String password = "1234";
	public static Connection con;
	private static boolean ready = false;
	
	static {
		try {
			con = DriverManager.getConnection(url, user, password);
			ready = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean isReady() {
		return ready;
	}

	@Override
	public boolean addGoods(Goods goods) {
		String sql = "insert into goods values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, goods.getGoodsName());
			stmt.setString(2, goods.getGoodsCode());
			stmt.setInt(3, goods.getQ1_selling());
			stmt.setInt(4, goods.getQ2_selling());
			stmt.setInt(5, goods.getQ3_selling());
			stmt.setInt(6, goods.getQ4_selling());
			stmt.setString(7, goods.getCompanyCode());
			int result = stmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				System.out.println("등록 실패?!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public Goods readGoods(String goodsCode) {
		Goods goods = new Goods();
		String sql = "select gname, gcode, q1_selling, q2_selling, q3_selling, q4_selling, p1.companycode, companyname"
				+ " from goods p1, company p2 where p1.companycode = p2.companycode and gcode = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, goodsCode);
			ResultSet result = stmt.executeQuery();
			result.next();
			goods.setGoodsName(result.getString(1));
			goods.setGoodsCode(result.getString(2));
			goods.setQ1_selling(result.getInt(3));
			goods.setQ2_selling(result.getInt(4));
			goods.setQ3_selling(result.getInt(5));
			goods.setQ4_selling(result.getInt(6));
			goods.setCompanyCode(result.getString(7));
			goods.setCompanyName(result.getString(8));
			return goods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoods(String goodsCode) {
		String sql = "delete from goods where gcode = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, goodsCode);
			int result = stmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				System.out.println("해당코드의 상품이 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean endApp() {
		if (con != null) {
			try {
				con.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceUpdate(String gcode, String change, Enum<?> what) {
		String sql = "update goods set " + what.name() + " = '" + change + "' " + 
					"where gcode = '" + gcode + "'";
		try {
			Statement stmt = con.createStatement();
			int result= stmt.executeUpdate(sql);
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Goods[] getAllGoodsInfo() {
		String sql = "select * from goods";
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			ArrayList<Goods> rtlist = new ArrayList<Goods>();
			while (result.next()) {
				Goods goods = new Goods();
				goods.setGoodsName(result.getString(1));
				goods.setGoodsCode(result.getString(2));
				goods.setQ1_selling(result.getInt(3));
				goods.setQ2_selling(result.getInt(4));
				goods.setQ3_selling(result.getInt(5));
				goods.setQ4_selling(result.getInt(6));
				goods.setCompanyCode(result.getString(7));
				rtlist.add(goods);
			}
			if (rtlist.isEmpty() == false) {
				Goods[] rtArr = rtlist.toArray(new Goods[0]);
				return rtArr;
			} else {
				System.out.println("DB에 암것도 없네");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Goods[] getGoodsInfoFromGName(String gname) {
		String sql = "select * from goods where gname = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, gname);
			ResultSet result = stmt.executeQuery();
			ArrayList<Goods> rtlist = new ArrayList<Goods>();
			while (result.next()) {
				Goods goods = new Goods();
				goods.setGoodsName(result.getString(1));
				goods.setGoodsCode(result.getString(2));
				goods.setQ1_selling(result.getInt(3));
				goods.setQ2_selling(result.getInt(4));
				goods.setQ3_selling(result.getInt(5));
				goods.setQ4_selling(result.getInt(6));
				goods.setCompanyCode(result.getString(7));
				rtlist.add(goods);
			}
			if (rtlist.isEmpty() == false) {
				Goods[] rtArr = rtlist.toArray(new Goods[0]);
				return rtArr;
			} else {
				System.out.println("그런거 암것도 없슴다~");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getYearlySalesFromCcode(String companycode) {
		String sql = "select q1_selling+q2_selling+q3_selling+q4_selling from goods"
				+ " where companycode = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, companycode);
			ResultSet result = stmt.executeQuery();
			int rtInt = -1;
			while (result.next()) {
				rtInt += result.getInt(1);
			}
			return rtInt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String getSupplierNameFromCcode(String gcode) {
		// 상품코드의 공급회사.
		String sql = "select companycode from goods where gcode = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, gcode);
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				String s = result.getString(1);
				sql = "select companyname from company where companycode = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, s);
				result = stmt.executeQuery();
				if (result.next()) {
					return result.getString(1);
				}
			} else {
				System.out.println("없군");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		String sql = "select companyname " +
//				"from company " +
//				"where companycode = (select companycode " +
//				"from goods " +
//				"where gcode = '" + gcode + "')";
//		try {
//			Statement stmt = con.createStatement();
//			ResultSet result = stmt.executeQuery(sql);
//			if (result.next()) {
//				return result.getString(1);
//			} else {
//				System.out.println("그런코드 상품읍따");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}

	public static void main(String[] args) {
		GoodsDAOImpl a = new GoodsDAOImpl();
		System.out.println(a.getSupplierNameFromCcode("abc-123"));
	}

	@Override
	public boolean addCompany(Company company) {
		String sql = "insert into company values(?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, company.getCompanycode());
			stmt.setString(2, company.getCompanyname());
			int result = stmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
