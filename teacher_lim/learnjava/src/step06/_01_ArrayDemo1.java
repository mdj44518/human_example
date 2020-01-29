package step06;

public class _01_ArrayDemo1 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		char[] str = {'a', 'b','c'};

		
		int[] numbers = new int[10];

		
		System.out.println("nums 배열의 사이즈(길이): " + nums.length);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

		String[] names = new String[3];
		names[0] = "홍길동";
		names[1] = "김철수";
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}

}
