package step07;

import java.util.Arrays;

public class MethodDemo02 {

	public static void main(String[] args) {
		int[] a = new int[50];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*1000);
		}

		int[] b = bubbleSort(a);
		//bubbleSort(a);
		
		System.out.println("정렬전");
		System.out.println(Arrays.toString(a));
		System.out.println("정렬후");
		System.out.println(Arrays.toString(b));
	}

	// BubbleSort
	// 입력: int[]
	// return: int[]
	public static int[] bubbleSort(int[] arr) {
		int[] sortedArr = new int[arr.length];
		System.arraycopy(arr, 0, sortedArr, 0, arr.length);
		
		for (int i = 0; i < sortedArr.length - 1; i++) {
			for (int j = 0; j < sortedArr.length - 1 - i; j++) {
				if (sortedArr[j] > sortedArr[j+1]) {
					int temp = sortedArr[j];
					sortedArr[j] = sortedArr[j+1];
					sortedArr[j+1] = temp;
				}
			}
		}
		
		return sortedArr;
	}
}









