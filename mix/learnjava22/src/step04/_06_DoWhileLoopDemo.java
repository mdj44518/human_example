package step04;

import java.util.Scanner;

public class _06_DoWhileLoopDemo {

	public static void main(String[] args) {
		// 사용자가 0 를 입력할 때까지 
		// 입력된 숫자를 더하는 프로그램
		
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int number;
		
		do {
			System.out.print("숫자입력: ");
			number = scanner.nextInt();
			sum += number;
		} while (number != 0);
		
		System.out.println("총합: " + sum);

	}

}
