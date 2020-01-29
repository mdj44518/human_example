package step06;

import java.util.Arrays;

public class ArrayDemo01 {

	public static void main(String[] args) {
		// int 배열에 열개의 숫자를 담고,
		// 총합을 구하시오.
		
		int cnt = 10;
		int[] nums = new int[cnt];
		
		for (int i = 0; i < cnt; i++) {
			nums[i] = (int)(Math.random() * 100) + 1;
		}
		
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}
		System.out.println(Arrays.toString(nums));
		
		//Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length -1 - i; j++) {
				if (nums[j] > nums[j+1]) { // 두 위치의 값을 교환
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
			
		}

		System.out.println(Arrays.toString(nums));
	}

}
