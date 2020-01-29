package step06;

import java.util.Arrays;

public class _04_ArrayCopyDemo1 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr_copy = arr;
		
		// 각 배열의 값 출력
		System.out.println("arr 배열");
		System.out.println(Arrays.toString(arr));
		System.out.println("arr_copy 배열");
		System.out.println(Arrays.toString(arr_copy));
		
		// 배열변수 의 값?
		System.out.println("arr: " + arr);
		System.out.println("arr_copy: " + arr_copy);
		
		// arr배열의 원소 값 변경
		arr[1] = 20;
		
		// 각배열 값 다시 출력
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr_copy));
	}

}
