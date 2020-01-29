package level1;

import java.util.Arrays;

public class NotConjNum {

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,2,3,3, 5,5,5, 4};
		int[] result = removeSame(arr);
		System.out.println(Arrays.toString(result));
	}

	public static int[] removeSame(int[] arr) {
		int count = 1;
		int prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (prev != arr[i]) {
				count++;
			}
			prev = arr[i];
		}
		
		int[] newArr = new int[count];
		newArr[0] = arr[0];
		prev = arr[0];
		int index = 1;
		for (int i = 1; i < arr.length; i++) {
			if (prev != arr[i]) {
				newArr[index] = arr[i];
				index++;
			}
			prev = arr[i];
		}
		return newArr;
	}
}
