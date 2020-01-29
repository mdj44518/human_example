package level1;

import java.util.Arrays;

public class RemoveMin {

	public static void main(String[] args) {
		int[] a = {10};
		RemoveMin min = new RemoveMin();
		System.out.println(Arrays.toString(min.solution(a)));
	}

	// 1. 최소값찾기
	// 2. 리턴할 배열을 생성
	// 3. 최소값을 제외한 값 복사
	public int[] solution(int[] arr) {
		// 특수상항
		if (arr.length == 1) {
//			int[] a = {-1};
//			return a;
			return new int[] {-1};
		}
		
		// 1.
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		
		//2.
		int[] result = new int[arr.length-1];
		
		//3.
		int rIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != min) {
				result[rIdx] = arr[i];
				rIdx++;
			}
		}
		
		return result;
	}
}
