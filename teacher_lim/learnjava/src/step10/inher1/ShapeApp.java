package step10.inher1;

public class ShapeApp {

	public static void main(String[] args) {
		Shape s = new Shape();
		s.draw();
		
		Circle c = new Circle(1.5);
		c.draw();
		c.setColor("Yellow");
		c.setStyle("dashed");
		
		System.out.println("Circle 속성들");
		System.out.println("면적: " + c.getArea());
		System.out.println("색깔: " + c.getColor());

		// 다음 실행은?
		Shape s2 = new Square(2.5);
		s2.draw();
		//s2.setWidth();
		((Square)s2).setWidth(10.0);
		System.out.println("사각형면적: " + s2.getArea());
	}

}
