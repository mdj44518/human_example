package step06;

import java.util.Arrays;

public class _05_ArrayCopyDemo2 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		// arr 복사
		int[] arr_copy = new int[arr.length];
		for (int i = 0; i < arr_copy.length; i++) {
			arr_copy[i] = arr[i];
		}
		
		// arr_copy 원소 값 변경
		arr_copy[1] = 20;
		
		// 각 배열 출력
		System.out.println("arr 배열");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("arr_copy 배열");
		for (int i = 0; i < arr_copy.length; i++) {
			System.out.print(arr_copy[i] + " ");
		}
		System.out.println();
	}

}
