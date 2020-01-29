package step04;

import java.util.Scanner;

public class SwitchDemo2 {  

	public static void main(String[] args) {
		// 사용자 점수 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("점수 입력: ");
		int score = scan.nextInt();
		
		switch (score) {
		case 100:
		case 99:
		case 98:
		case 97:
		case 96:
		case 95:
			System.out.println("아주 우수");
			break;
		case 94: case 93: case 92: case 91:
		case 90:
			System.out.println("우수");
			break;
		case 89: case 88: case 80:
			System.out.println("준우수");
			break;
		case 70:
			System.out.println("보통");
			break;
		default:
			System.out.println("노력요");
			break;
		}
	}

}
