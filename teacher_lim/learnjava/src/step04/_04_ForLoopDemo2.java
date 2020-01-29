package step04;

public class _04_ForLoopDemo2 {
	public static void main(String[] args) {
		// 구구단을 모두 출력
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int result = i * j;
				System.out.println(i + " * " + j + " = " + result);
			}
			System.out.println();
		}
	}
}
