package practice;

import java.util.Arrays;

class Sort {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		choiceSort(arr, true);
		System.out.println(Arrays.toString(arr));
	}
	
	static void choiceSort(int[] arr, boolean reverseOn) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (reverseOn ? arr[i] < arr[j] : arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
