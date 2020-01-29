package step07;

import java.util.Arrays;

public class _06_PassingArrayDemo {

	public static void main(String[] args) {
		
		int[] arr = {5, 3, 6, 1, 7, 2};
		
		sortArray(arr);
		
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = {1, 5, 4, 3, 7, 2};
		System.out.println("Before Sort...");
		System.out.println(Arrays.toString(arr2));
		int[] sortedArr = arraySort(arr2);
		System.out.println("After Sort...");
		System.out.println(Arrays.toString(arr2));
		System.out.println("Sorted Array...");
		System.out.println(Arrays.toString(sortedArr));
	}
	
	public static void sortArray(int[] arr) {
		Arrays.sort(arr);
	}
	
	public static int[] arraySort(int[] arr) {
		int[] copyArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(copyArr);
		return copyArr;
	}
}
