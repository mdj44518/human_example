package step05;

import java.util.Scanner;

public class StringDemo2 {

	public static void main(String[] args) {
		System.out.print("전화번호 입력");
		Scanner scan = new Scanner(System.in);
		String phNum = scan.nextLine();
		phNum = phNum.trim();
		
		// 지역번호 추출
		// 1. '-' 위치
		int firstIdx = phNum.indexOf('-');
		int secondIdx = phNum.indexOf('-', firstIdx+1);
		
		System.out.println(phNum.substring(firstIdx+1, secondIdx));
	}

}






