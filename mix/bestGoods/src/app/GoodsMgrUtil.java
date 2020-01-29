package app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import dao.GoodsDAOImpl;
import model.Goods;

public class GoodsMgrUtil {
	
	private static Random r = new Random();
	
	enum goodsList {
		FAN("선풍기"),
		RF("냉장고"),
		MOB("휴대폰"),
		AIR("에어컨");
		
		private String value;
		private goodsList(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		
		public static goodsList getGoodsList() {
			goodsList[] list = goodsList.values();
			return list[(int)(Math.random() * list.length)];
		}
	}
	
//	public static void main(String[] args) {
//		System.out.println(GoodsMgrUtil.goodsList.FAN.ordinal());
//	}
	
	public static Goods getNewGoods() {
		//goods 프라덕 만들어서 주자 원리 원칙 따져서.
		Goods goods = new Goods();
		//상품명 셋팅.
		goodsList en = goodsList.getGoodsList();
		goods.setGoodsName(en.getValue());
		System.out.println("상품명 : "+ en.getValue());
		//상품 코드 생성, 검사, 추가
		//코드 생성 쿼리로.
		int ranNum = codecall(en);
//		int ranNum = r.nextInt(90000) + 100;
		String readyCode = en.name() + "-" + ranNum;
		while (true) {
			if (checkCode(readyCode)) {
				goods.setGoodsCode(readyCode);
				break;
			} else {
				ranNum = r.nextInt(90000) + 100;
				readyCode = en.name() + "-" + ranNum;
			}
		}
		// 판매량 아무렇게나~
		goods.setQ1_selling(r.nextInt(200));
		goods.setQ2_selling(r.nextInt(200));
		goods.setQ3_selling(r.nextInt(200));
		goods.setQ4_selling(r.nextInt(200));
		//회사코드와 이름 받아와서 넣는다.
		String[] company = randomChoiceCompany();
		goods.setCompanyCode(company[0]);
		goods.setCompanyName(company[1]);
		return goods;
	

	}
	
	private static int codecall(goodsList en) {
		GoodsDAOImpl dao = new GoodsDAOImpl();
		PreparedStatement stmt = null;
		ResultSet result = null;
		String sql = "select " + en.name() + "codeseq.nextval from dual";
		if (dao.isReady()) {
			try {
				stmt = dao.con.prepareStatement(sql);
				result = stmt.executeQuery();
				result.next();
				return result.getInt(1);
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
				if (result != null) {
					try {
						result.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	return -1;
	}
	
	public static void main(String[] args) {
		goodsList en = goodsList.getGoodsList();
		codecall(en);
	}

	private static String[] randomChoiceCompany() {
		GoodsDAOImpl dao = new GoodsDAOImpl();
		PreparedStatement stmt = null;
		ResultSet result = null;
		if (dao.isReady()) {
			String sql = "select count(*) from company";
			
			try {
				stmt = dao.con.prepareStatement(sql);
				result = stmt.executeQuery();
				result.next();
				int numLength = result.getInt(1);
				
				sql = "select * from company";
				result = stmt.executeQuery(sql);
				
				int randomNum = r.nextInt(numLength) + 1;
				for (int i = 0; i < randomNum; i++) {
					result.next();
				}
				String[] rt = new String[2];
				rt[0] = result.getString(1);
				rt[1] = result.getString(2);
				return rt;
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
				if (result != null) {
					try {
						result.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		return null;
		
	}

	private static boolean checkCode(String goodsCode) {
		// TODO Auto-generated method stub
		// 존재하는 코드인지 확인.
		String sql = "select gcode from goods where gcode = '" + goodsCode + "'";
		GoodsDAOImpl dao = new GoodsDAOImpl();
		Statement stmt = null;
		ResultSet result = null;
		try {
			stmt = dao.con.createStatement();
			result = stmt.executeQuery(sql);
			return result.next() == false;
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
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
