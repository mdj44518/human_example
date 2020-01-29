package step04;

import java.util.Scanner;

public class ForLoopDemo03 {

	public static void main(String[] args) {
		// 사용자로 부터 정수입력
		Scanner scan = new Scanner(System.in);
		System.out.print("정수입력: ");
		String strNum = scan.nextLine();
		
		boolean isValid = true;
		// strNum에 담긴 문자가 적절한가?
		// "ab123" , "123"
		for (int i = 0; i < strNum.length(); i++) {
			if (strNum.charAt(i) >= 48 && strNum.charAt(i) <= 57) {
				// ok
			} else {
				// not ok
				System.out.println("유효하지 않은 숫자입니다.");
				isValid = false;
				break;
			}
		}
		
		if (isValid) {
			int num = Integer.parseInt(strNum);
			System.out.println("입력 정수는 " + num);
		} else {
			
		}
	}

}
