package step07;

import java.util.Calendar;

public class _01_MethodDemo1 {
	
	public static void main(String[] args) {
		printCurrentTime();
		/*
		_01_MethodDemo1.printCurrentTime();
		_01_MethodDemo1 obj = new _01_MethodDemo1();
		obj.printCurrentTime();
		*/
		int sum = sum(10, 20);
		System.out.println("두 수의 합: " + sum);
	}
	
	public static void printCurrentTime() {
		Calendar cal = Calendar.getInstance();
		System.out.println("현재시간: " + cal.getTime());
	}

	public static int sum(int i, int j) {
		int result = i + j;
		
		return result;
	}
}
