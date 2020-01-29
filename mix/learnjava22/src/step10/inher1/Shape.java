package step10.inher1;

public class Shape {

	private String color;
	private String style;
	
	public Shape() {
		
	}
	
	public void draw() {
		System.out.println("Shape is drawn");
	}
	
	public void erase() {
		System.out.println("Shape is erased...");
	}
	
	public double getArea() { 
		return 0.0;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
}
