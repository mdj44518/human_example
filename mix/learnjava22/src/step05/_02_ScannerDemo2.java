package step05;

import java.util.Scanner;

public class _02_ScannerDemo2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int count = 0;
		double avg = 0.0;
		
		System.out.println("점수를 입력하세요");
		while (scanner.hasNextInt()) {
			int score = scanner.nextInt();
			sum += score;
			count++;
		}
		
		avg = sum / (double)count;
		System.out.println("총합: " + sum);
		System.out.println("평균: " + avg);
	}

}
