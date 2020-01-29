package step04;

import java.util.Scanner;

public class SwitchIfDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("점수입력 ");
		String strScore = scan.next();
		int score = Integer.parseInt(strScore);
		
		score = score / 10;
	}

}
