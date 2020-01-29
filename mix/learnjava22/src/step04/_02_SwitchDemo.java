package step04;

import java.util.Scanner;

public class _02_SwitchDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("명령입력(i/d/q): ");
		String cmdStr = scanner.next();
		char cmd = cmdStr.charAt(0);
		
		switch (cmd) {
		case 'i':
			System.out.println("정보를 추가합니다");
			break;
		case 'd':
			System.out.println("정보를 삭제합니다");
			break;
		case 'q':
			System.out.println("종료합니다");
			break;
		default:
			System.out.println("알수 없는 명령입니다");
			break;
		}
	}

}
