package step07;

import java.util.Arrays;
import java.util.Random;

public class _03_PassingParamDemo {

	public static void main(String[] args) {
		int m = 10;
		m = changeNum(m);
		System.out.println("After changeNum() call: m --> " + m);

		String message = "안녕하세요";
		//changeGreet(message);
		System.out.println("After changeGreet() call: message --> " + message);
		//message = changeGreet(message);
		System.out.println("After changeGreet() call2: message --> " + message);
		
		int[] arr = {1, 2, 3, 4, 5};
		changeArr(arr);
		System.out.println("After changeArr() call: arr --> " + Arrays.toString(arr));
	}

	public static int changeNum(int num) {
		System.out.println("changeNum() 함수 시작");
		System.out.println("전달 받은 값: " + num);
		
		num = (int)(Math.random() * 10);
	
		System.out.println("변경된 값: " + num);		
		System.out.println("changeNum() 함수 끝");
		
		return num;
	}
	
	public static String changeGreet(String message) {
		message = "Hello World!";
		return message;
	}
	
	public static void changeArr(int[] arr) {
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(50);
		}
	}
}
