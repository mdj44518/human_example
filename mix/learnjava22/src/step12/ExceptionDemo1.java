package step12;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		try {
			int data = 100 / 0;
			System.out.println(data);
		} catch (ArithmeticException e) {
			System.out.println("산술연산 예외 발생");
		}

		System.out.println("done...");
	}

}
