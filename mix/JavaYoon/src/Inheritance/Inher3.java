package Inheritance;

public class Inher3 extends Inher2 {
	
	
	void test() {
		System.out.println(super.getClass().getEnclosingConstructor().getName());
		super.test();
		System.out.println("난 둘째");
	}
	
	public static void main(String[] args) {
		Inher3 a = new Inher3();
		
		a.test();
	}
}