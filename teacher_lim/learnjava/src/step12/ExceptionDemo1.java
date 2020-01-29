package step12;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		System.out.println(divide(10, 0));
		
		System.out.println("done...");
	}

	public static double divide(int a, int b) {
		byte result = 0;
		try {
			result = (byte)(a / b);
		} catch (Exception e) {
			System.out.println("산술연산 예외 발생");
			System.out.println("b 값을 잘봐!!!");
		}
		
		return result;
	}
}
