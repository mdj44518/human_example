package step05;

import java.util.Scanner;

public class _03_ScannerDemo3 {

	public static void main(String[] args) {
		String input = "Hello 1 F 3.5";
		Scanner scanner = new Scanner(input);
		
		String str = scanner.next();
		int num = scanner.nextInt();
		int num16 = scanner.nextInt(16);
		double dNum = scanner.nextDouble();
		
		System.out.println(str);
		System.out.println(num);
		System.out.println(num16);
		System.out.println(dNum);
	}

}
