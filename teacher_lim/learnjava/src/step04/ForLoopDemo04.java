package step04;

import java.util.Random;

public class ForLoopDemo04 {

	public static void main(String[] args) {
		//반복문
		// 반복회수
		int evenCount = 0;
		int oddCount = 0;
		for (int i = 0; i < 10; i++) {
			/*
			Random rand = new Random();
			int num = rand.nextInt(32);
			*/
			int num = (int)(Math.random() * 32);
			
			if (num % 2 == 0) {	// 짝수 0
				evenCount++;
			} else {	// 홀 1
				oddCount++;
			}
		}
		
		double oddPercent = (double)oddCount / 100000;
		System.out.println("홀수의 개수: " + oddCount + "(" + oddPercent + ")");
		System.out.println("짝수의 개수: " + evenCount);
		System.out.println("\n");
		
		// 반복시, 변경되야 하는 인덱스
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("(" + i + "," + j + ")");
			}
		}
	}

}
