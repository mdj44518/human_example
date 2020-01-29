package practice;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("두 숫자와 연산자를 입력해주세요 : ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		char ch = scan.next().charAt(0);
//		String choice = "";
//		
//		switch (ch) {
//		case '+':choice = "Add";break;
//		case '-':choice = "Sub";break;
//		case '*':choice = "Mul";break;
//		case '/':choice = "Div";
//		}
		Computational cls = null;
		try {		  cls = (Computational)Class.forName("practice.Cal" + (int)ch).newInstance();}
		catch (Exception e) {System.err.println("잘못된 연산자입니다.");}
		
		cls.setValue(a, b);
		cls.calculate();
	}
}
abstract class Computational {
	int a, b;
	public final void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	abstract void calculate();
}
//class Add extends Computational {
class Cal43 extends Computational {
	public void calculate() {System.out.println(a + b);}
}
//class Sub extends Computational {
class Cal45 extends Computational {
	public void calculate() {System.out.println(a - b);}
}
//class Mul extends Computational {
class Cal42 extends Computational {
	public void calculate() {System.out.println(a * b);}
}
//class Div extends Computational {
class Cal47 extends Computational {
	public void calculate() {System.out.printf("%.2f\n",(double)a / b);}
}