package step13;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo5 {

	public static void drawShapes(List<? extends Shape> shapes) {
		for (Shape s : shapes) {
			s.draw();
		}
	}
	
	public static void main(String[] args) {
		List<Rectangle> rectList = new ArrayList<> ();
		rectList.add(new Rectangle());
		rectList.add(new Rectangle());
		
		List<Circle> cirList = new ArrayList<> ();
		cirList.add(new Circle());
		
		drawShapes(rectList);
		drawShapes(cirList);

	}

}

class Shape {
	void draw() { }
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("drawing rectangle");
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("drawing circle");
	}
}
