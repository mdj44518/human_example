
class GoodsStock {
	String goodsCode;
	int stockNum;
	
	public GoodsStock(String goodsCode, int stockNum) {
		this.goodsCode = goodsCode;
		this.stockNum = stockNum;
	}
	
	void addStock(int amount) {
		stockNum += amount;
	}
	int subtractStock(int amount) {
		if (stockNum < amount) {
			return 0;
		}
		stockNum -= amount;
		return amount;
	}
}
