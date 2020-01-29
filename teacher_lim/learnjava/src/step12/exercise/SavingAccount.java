package step12.exercise;

public class SavingAccount extends Account {
	private SavingAcctType sType;
	private double rate;
	
	public SavingAccount(String accName, String ownerName, String accNum) {
		super(accName, ownerName, accNum);
	}
	
	@Override
	public void save(double money) {
		double a = getAmount();
		a += money + money * rate;
		setAmount(a);
	}
	
	//예금, 예적금 상품은 출금이 가능하고,
	// 적금상품은 출금이 불가능
	@Override
	public double withdraw(double money) {
		if (sType == SavingAcctType.GGSAVING) {
			return 0.0;
		}
		
		double cur = getAmount();
		if (cur >= money) {
			cur -= money;
			setAmount(cur);
			return money;
		} else {
			return 0.0;
		}
	}
	
	@Override
	public double getTotal() {
		return getAmount();
	}

	public SavingAcctType getsType() {
		return sType;
	}

	public void setsType(SavingAcctType sType) {
		this.sType = sType;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
