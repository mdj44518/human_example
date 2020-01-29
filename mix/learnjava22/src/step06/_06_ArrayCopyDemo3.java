package step06;

import java.util.Arrays;

public class _06_ArrayCopyDemo3 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		int[] arr_copy1 = arr.clone();
		arr_copy1[0] = 10;
		
		int[] arr_copy2 = new int[arr.length];
		System.arraycopy(arr, 0, arr_copy2, 0, 5);
		
		int[] arr_copy3 = Arrays.copyOf(arr, arr.length);
		
		int[] arr_copy4 = Arrays.copyOfRange(arr, 0, 3);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr_copy4));
		
	}

}
