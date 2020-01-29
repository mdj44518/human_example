package step10.inher2;

public class InheritanceDemo {

	public static void main(String[] args) {
		Triangle t1 = new Triangle(3, 2.5);
		Triangle t2 = new Triangle(3, 2.5);
		
		if (t1.equals(t2)) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}

		// toString() 메소드  overriding
		System.out.println(t1);
		System.out.println(t2);
	}

}
