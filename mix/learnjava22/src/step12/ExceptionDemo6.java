package step12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("입장하려면 당신의 나이를 입력하세요: ");
			try {
				int age = Integer.parseInt(scanner.nextLine());
				
				if (age < 19) {
					throw new InvalidAgeException(age + " 는 부적절합니다.");
				} else {
					System.out.println("당신은 입장되었습니다");
				}
				break;
			} catch (InputMismatchException | NumberFormatException e ) {
				System.out.println("숫자로만 입력하세요");
			} catch (InvalidAgeException e) {
				System.out.println("적절한 나이가 아닙니다.");
				break;
			} finally {
				
			}
		}
		
		scanner.close();
	}

}

class InvalidAgeException extends Exception {
	
	public InvalidAgeException(String s) {
		super(s);
	}
}
