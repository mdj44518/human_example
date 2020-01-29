package step04;

import java.util.Scanner;

public class ForLoopDemo02 {

	/*
	 * 사용자로 부터 갯수를 입력받아,
	 * 해당 갯수만큼의 점수를 입력받아
	 * 
	 * 점수의 총합과 평균을 구하는 프로그램
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사용자로 부터 개수를 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("개수입력: ");
		int num = scan.nextInt();
		
		int score = 0;
		// 개수만큼 점수입력
		for (int i = 1; i <= num; i++) {
			System.out.print("점수입력: ");
			score = score + scan.nextInt();
		}
		
		System.out.println("총합: " + score);
		System.out.println("평균: " + ((double)score / num));
	}

}
