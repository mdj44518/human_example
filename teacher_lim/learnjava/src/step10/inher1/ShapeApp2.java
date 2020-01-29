package step10.inher1;

public class ShapeApp2 {

	public static void main(String[] args) {
		// Shape 들을 만들어 면적을 구하고 시퍼
		
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(5.5);
		shapes[1] = new Square(10.0);
		shapes[2] = new Triangle(4.5, 3.7);
		
		double sum = 0.0;
		for (int i = 0; i < shapes.length; i++) {
			sum += getShapeArea(shapes[i]);
		}
		
		System.out.println("Sum: " + sum);
	}
	
	public static double getShapeArea(Shape s) {
		return s.getArea();
	}

}
