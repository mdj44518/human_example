package step04;

import java.util.Scanner;

public class ForLoopDemo01 {

	public static void main(String[] args) {
		// n을 사용자로 부터
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		// 1 ~ n까지 정수중에,
		// 3의 배수만 출력
		for (int i = 1; i <= n; i++) {
			// 매 스텝마다 i의 값이 1에서 100으로 셋팅
			// i의 값이 3의 배수인지?
			if (i % 3 == 0) { // 3의 배수
				System.out.println(i);
			}
		}
		

	}

}
