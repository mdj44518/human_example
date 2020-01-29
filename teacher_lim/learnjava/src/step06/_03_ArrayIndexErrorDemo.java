package step06;

public class _03_ArrayIndexErrorDemo {

	public static void main(String[] args) {
		int[] values = {10, 20, 30, 40, 50};

		for (int i = 0; i <= values.length; i++) {
			values[i] += values[i] * 2;
		}
	}

}
