package step07;

public class _02_MethodDemo2 {

	public static void main(String[] args) {
		int number = 16;
		
		if (isEven(number)) {
			System.out.println(number + " 은 짝수입니다");
		} else {
			System.out.println(number + " 은 홀수입니다");
		}

	}

	public static boolean isEven(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
