package step12.exercise;

public class DepositAccount extends Account {
	private double fee;
	
	public DepositAccount(String accName, String ownerName, String accNum) {
		super(accName, ownerName, accNum);
	}
	
	@Override
	public void save(double money) {
		double a = getAmount();
		a += money;
		if (a < fee) {
			a = 0;
		} else {
			a -= fee;
		}
		
		setAmount(a);
	}
	
	@Override
	public double withdraw(double money) {
		double cur = getAmount();
		
		if (cur > money + fee) {
			cur -= money + fee;
			setAmount(cur);
		} else {
			return 0.0;
		}
		
		return money;
	}
	
	@Override
	public double getTotal() {
		return getAmount();
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
}
