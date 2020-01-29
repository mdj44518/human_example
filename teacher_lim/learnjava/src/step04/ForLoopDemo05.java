package step04;

import java.util.Scanner;

public class ForLoopDemo05 {

	/*
	 * 삼각형 그리기
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삼각형의 단: ");
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			// 공백을 그리는 작업
			for (int j = n-1; j > i; j--) {
				System.out.print(' ');
			}
			
			for (int j = 0; j < 2*i +1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
