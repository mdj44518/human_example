package model;

public class Product {
	private String pName;
	private String pCode;
	private int firstQ;
	private int secondQ;
	private int thirdQ;
	private int fourthQ;
	private String supCode;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getFirstQ() {
		return firstQ;
	}

	public void setFirstQ(int firstQ) {
		this.firstQ = firstQ;
	}

	public int getSecondQ() {
		return secondQ;
	}

	public void setSecondQ(int secondQ) {
		this.secondQ = secondQ;
	}

	public int getThirdQ() {
		return thirdQ;
	}

	public void setThirdQ(int thirdQ) {
		this.thirdQ = thirdQ;
	}

	public int getFourthQ() {
		return fourthQ;
	}

	public void setFourthQ(int fourthQ) {
		this.fourthQ = fourthQ;
	}

	public String getSupCode() {
		return supCode;
	}

	public void setSupCode(String supCode) {
		this.supCode = supCode;
	}

	@Override
	public String toString() {
		return "Product [pName=" + pName + ", pCode=" + pCode + ", firstQ=" + firstQ + ", secondQ=" + secondQ
				+ ", thirdQ=" + thirdQ + ", fourthQ=" + fourthQ + ", supCode=" + supCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pCode == null) ? 0 : pCode.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (pCode == null) {
			if (other.pCode != null)
				return false;
		} else if (!pCode.equals(other.pCode))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		return true;
	}

	
}
