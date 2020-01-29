package level1;

import java.util.Arrays;

public class FindKthNum {

	public static void main(String[] args) {
		int[] arr = {1,5,2,6,3,7,4};
		int[][] com = {
				{2, 5, 3}, {4, 4,1}, {1,7,3}
		};

		int[] result = findKthNumbers(arr, com);
		System.out.println(Arrays.toString(result));
	}

	// K번째 숫를 찾는 메소드
	// 입력:  int[], [i,j,k]원소를 배열
	// 리턴: int[]
	public static int[] findKthNumbers(int[] array, int[][] ijk) {
		int[] result = new int[ijk.length];
		
		for (int i = 0; i < ijk.length; i++) {
			result[i] = findKthNum(array, ijk[i]);
		}
		
		return result;
	}
	
	public static int findKthNum(int[] array, int[] ijk) {
		int len = ijk[1] - ijk[0] + 1;
		int[] result = new int[len];
		
		int startIdx = ijk[0] - 1;
		for (int i = 0; i < result.length; i++) {
			result[i] = array[startIdx];
			startIdx++;
		}
		
		Arrays.sort(result);
		
		return result[ijk[2]-1];
	}
}
