package dao;

import model.Company;
import model.Goods;

public interface GoodsDAO {
	// 기능 (C.R.U.D)
	// 사용자 추가 (Create)
	// 사용자 조회 (Read)
	// 사용자 변경 (Update)
	// 사용자 삭제 (Delete)
	
	public boolean addGoods(Goods goods);
	public Goods readGoods(String goodsCode);
	public boolean updateGoods(Goods goods);
	public boolean deleteGoods(String goodsCode);
	public boolean choiceUpdate(String gcode, String change, Enum<?>what);
	
	public Goods[] getAllGoodsInfo();
	public Goods[] getGoodsInfoFromGName(String gname);
	//상품코드 = 연판매량
	public int getYearlySalesFromCcode(String companycode);
	//상품코드 = 공급회사
	public String getSupplierNameFromCcode(String gcode);
	
	public boolean addCompany(Company company);
	//선풍기 상품이름에 1분기 판매량 합
}
