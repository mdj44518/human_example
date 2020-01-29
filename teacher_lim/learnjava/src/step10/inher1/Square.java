package step10.inher1;

public class Square extends Shape {

	private double width;
	
	public Square(double width) {
		this.width = width;
	}
	
	public void draw() {
		System.out.println("Square is drawn");
	}
	
	public void erase() {
		System.out.println("Square is erased...");
	}
	
	@Override
	public double getArea() {
		return width * width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
}
