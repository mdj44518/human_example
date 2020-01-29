package step07;

import java.util.Arrays;

public class MethodDemo01 {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		int[] arr = swap(a, b);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * 입력: int a, int b
	 * 출력: int[]
	 */
	public static int[] swap(int a, int b) {
		int[] result = new int[2];
		
		result[0] = b;
		result[1] = a;
		
		return result;
	}

}







