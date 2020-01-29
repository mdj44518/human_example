package step02;

public class _03_TypeCastingDemo {

	public static void main(String[] args) {
		// 묵시적 형변환
		int val = 'a';
		
		System.out.println(val);
		// 강제적 형변환
		System.out.println((char)val);
		
		byte val2 = 10;
		// val2 = val2 + 10; 에러 발생이유?
		
		String message = "Hello ";
		message = message + 123;
		
		System.out.println(message);
	}

}
