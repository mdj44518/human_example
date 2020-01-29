package step03;

import java.util.Scanner;

public class _01_OperatorDemo {

	public static void main(String[] args) {
		// 대입연산자
		int var = 10;
		String message = new String("Java");
		
		// 산술연산자
		var = 10 + 2;
		var = 5 / 2;
		var = 5 % 2;
		
		// 증감연산자
		var++;
		++var;
		
		int newVar = var++;
		
		newVar += 5;	// newVar = newVar + 5;
		newVar -= 4;	// newVar = newVar - 5;
		newVar /= 2;	// newVar = newVar / 5;
		
		// 비교연산자
		if (newVar > 15) {
			System.out.println("15를 넘습니다.");
		} else {
			System.out.println("15 이하입니다");
		}
		
		// 논리연산자
		boolean result = (10 > 5) && (5 < 3);
		
		if (newVar < 15 || newVar >= 20) {
			System.out.println("조건을 만족합니다");
		}
		
		// 콘솔을 통해 사용자 입력을 받을 수 있는 객체 생성
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int number = scanner.nextInt();
		
		System.out.println("입력하신 값: " + number);
		
		// 3항 연산자
		char ch = number == 3 ? 'c' : 'n';
		System.out.println(ch);
	}

}
