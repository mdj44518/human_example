package step04;

public class WhileLoopDemo01 {

	public static void main(String[] args) {
		// 100이하의 자연수 중 3의 배수 이거나
		// 5의 배수의 합
		int sum = 0;
		int number = 1;
		/*
		 * while ( number <= 100) { if (number % 3 == 0 || number % 5 == 0) { sum = sum
		 * + number; } number++; // number = number + 1; }
		 */
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		System.out.println("합: " + sum);
		
		
	}

}
