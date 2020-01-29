package step10.inher1;

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
