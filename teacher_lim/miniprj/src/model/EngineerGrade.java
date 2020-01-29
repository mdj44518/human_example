package model;

public enum EngineerGrade {
	E1(0.02),
	E2(0.03),
	E3(0.04),
	E4(0.05),
	E5(0.1);
	
	private double rate; 
	
	private EngineerGrade(double rate) {
		this.rate = rate;
	}
	
	public double getIncentiveRate() {
		return rate;
	}
}
