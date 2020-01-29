package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Goods;

public class DDAO extends GoodsDAOImpl {
	
//	static class Item extends Goods {
//		double bu;
//		
//		@Override
//		public String toString() {
//			return String.format("%s= 품종 : %s(%s) 판매량 : %d / 품종 점유율 : %.2f", getCompanyName(), getGoodsName(), getGoodsCode(), getQ1_selling(), bu);
//		}
//	}
	static class Disposable {
		String disposableName;
		int disposableNum;
	}

	public static Goods bestGoods() {
		String sql = "select gname, sum(q1_selling + q2_selling + q3_selling + q4_selling) " + 
				"from goods " + 
				"group by gname";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			ArrayList<Disposable> disList = new ArrayList<>();
			while (result.next()) {
				Disposable a = new Disposable();
				a.disposableName = result.getString(1);
				a.disposableNum = result.getInt(2);
				disList.add(a);
			}
			// 최고판매를 찾거랏
			int bestIdx = 0;
			for (int i = 0; i < disList.size(); i++) {
				if (disList.get(bestIdx).disposableNum < disList.get(i).disposableNum) {
					bestIdx = i;
				}
			}
			sql = "select gname, gcode, (q1_selling + q2_selling + q3_selling + q4_selling) ss , companyname " + 
					"from goods p1, company p2 " + 
					"where p1.companycode = p2.companycode and gname = ? " + 
					"order by ss desc";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, disList.get(bestIdx).disposableName);
			result = stmt.executeQuery();
			result.next();
			int bestIdx2 = bestIdx;
			Goods rt = new Goods() {
					double occupancy;
					
					@Override
					public String toString() {
						double occupancy = (double)getQ1_selling() / disList.get(bestIdx2).disposableNum * 100;
						return String.format("%s= 품종 : %s(%s) 판매량 : %d / 품종 점유율 : %.2f", getCompanyName(),
								getGoodsName(), getGoodsCode(), getQ1_selling(), occupancy);
					}
			};
			rt.setGoodsName(result.getString(1));
			rt.setGoodsCode(result.getString(2));
			rt.setQ1_selling(result.getInt(3));
			rt.setCompanyName(result.getString(4));
			//왜 바라볼수없지..?!  goods 타입이라서!  어나니머스는 이름이 없기에 불러올 방법이없음.
//			rt.occupancy = (double)rt.getQ1_selling() / disList.get(bestIdx).disposableNum * 100;
			return rt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Goods qBestGoods(int n) {
		String sql = "select gname, gcode, q"+n+"_selling " + 
				"from goods " + 
				"where q"+n+"_selling = (select max(q"+n+"_selling) from goods)";
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			result.next();
			Goods rt = new Goods() {
				@Override
				public String toString() {
					return "상품명 : " + getGoodsName() + ", 상품코드 : " + getGoodsCode() + ", "+n+"분기 판매량 : " + getQ1_selling();
				}
			};
			rt.setGoodsName(result.getString(1));
			rt.setGoodsCode(result.getString(2));
			rt.setQ1_selling(result.getInt(3));
			return rt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
