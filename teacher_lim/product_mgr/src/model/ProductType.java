package model;

public enum ProductType {
	TV("티브이"),
	RF("냉장고"),
	AIR("에어콘"),
	FAN("선풍기"),
	MOB("휴대폰"),
	DES("컴퓨터"),
	LAP("노트북"),
	TAB("태블릿"),
	VAC("청소기"),
	PUR("공기청정기");
	
	
	private String pName;
	
	private ProductType(String name) {
		this.pName = name;
	}
	
	public String getProductName() {
		return pName;
	}
}
