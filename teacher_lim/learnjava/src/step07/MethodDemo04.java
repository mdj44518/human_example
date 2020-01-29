package step07;

import java.util.Arrays;

public class MethodDemo04 {

	/*
	 * 최대값 / 최소값 찾는 메소드
	 */
	public static void main(String[] args) {
		int[] arr = new int[30];
		
		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = (int)(Math.random()*100);
		}
		System.out.println(Arrays.toString(arr));
		
		int m = max(arr);
		System.out.println("최대값: " + m);
		int m2 = min(arr);
		System.out.println("최소값: " + m2);
	}
	
	private static int min(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	//최대값
	// 입력: int[]
	// 리턴: 최대값
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	// 최소값
	// 입력: int[]
	// 리턴: 최소값
}
