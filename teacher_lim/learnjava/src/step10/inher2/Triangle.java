package step10.inher2;

public class Triangle extends Shape {

	private double base;
	private double height;

	public Triangle(double b, double h) {
		this.base = b;
		this.height = h;
	}

	public void draw() {
		System.out.println("Triangle is drawn");
	}

	public void erase() {
		System.out.println("Triangle is erased...");
	}

	@Override
	public double getArea() {
		return 0.5 * base * height;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(base);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Triangle other = (Triangle) obj;
		if (Double.doubleToLongBits(base) != Double.doubleToLongBits(other.base))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + "]";
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
