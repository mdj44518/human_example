package step04;

public class _03_ForLoopDemo {

	public static void main(String[] args) {
		//구구단 9단을 출력
		int dan = 9;
		for (int i = 2; i < 10; i++) {
			int result = dan * i;
			System.out.println(dan + " * " + i + " = " + result);
		}
		System.out.println("\n");
		
		// 1에서 100까지의 합
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("1 ~ 100 합: " + sum);
		System.out.println("\n");
		
	}

}
