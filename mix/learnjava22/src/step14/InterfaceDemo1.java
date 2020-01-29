package step14;

public class InterfaceDemo1 {

	public static void main(String[] args) {
		A myObj = new A("Hello");
		B yourObj = new B(123);
		
		myPrinter(myObj);
		myPrinter(yourObj);
	}
	
	public static void myPrinter(Printable p) {
		p.print();
	}

}

interface Printable {
	void print();
}

class A implements Printable {

	private String message;
	
	public A(String msg) {
		this.message = msg;
	}
	
	@Override
	public void print() {
		System.out.println("my message: " + message);
	}
	
}

class B implements Printable {

	private int value;
	
	public B(int a) {
		value = a;
	}
	
	@Override
	public void print() {
		System.out.println("my message: " + value);
	}
	
}
