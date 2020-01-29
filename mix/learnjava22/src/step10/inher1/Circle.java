package step10.inher1;

public class Circle extends Shape {

	private double radius;
	
	public Circle(double r) {
		this.radius = r;
	}
	
	public void draw() {
		System.out.println("Circle is drawn");
	}
	
	public void erase() {
		System.out.println("Circle is erased...");
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}