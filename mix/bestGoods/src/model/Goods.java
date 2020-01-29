package model;

public class Goods {
	
	private String goodsName;
	private String goodsCode;
	private int Q1_selling;
	private int Q2_selling;
	private int Q3_selling;
	private int Q4_selling;
	private String companyCode;
	private String companyName;
	
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	
	public int getQ1_selling() {
		return Q1_selling;
	}
	public void setQ1_selling(int q1_selling) {
		Q1_selling = q1_selling;
	}
	public int getQ2_selling() {
		return Q2_selling;
	}
	public void setQ2_selling(int q2_selling) {
		Q2_selling = q2_selling;
	}
	public int getQ3_selling() {
		return Q3_selling;
	}
	public void setQ3_selling(int q3_selling) {
		Q3_selling = q3_selling;
	}
	public int getQ4_selling() {
		return Q4_selling;
	}
	public void setQ4_selling(int q4_selling) {
		Q4_selling = q4_selling;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Goods [goodsName=" + goodsName + ", goodsCode=" + goodsCode + ", Q1_selling=" + Q1_selling
				+ ", Q2_selling=" + Q2_selling + ", Q3_selling=" + Q3_selling + ", Q4_selling=" + Q4_selling
				+ ", companyCode=" + companyCode + ", companyName=" + companyName + "]";
	}
	
}
