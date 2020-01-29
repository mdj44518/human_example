
class Quiz {

	public static void main(String[] args) {
		
		// 문제 1. 1부터 100까지 수 중에서 짝수만 출력하는 예제를 만드세요.
		for (int i = 2; i <= 100; i+=2) {
			System.out.print(i+",");
		}
		System.out.println();
		
		//문제 2 구구단을 7단을 출력하세요.
		for (int i = 1; i < 10; i++) {
			System.out.println("7 x " + i + " = " + 7*i);
		}
		
		//문제 3 구구단을 2단부터 9단까지 모두 출력하세요.(while or do while)
		int dan = 2;
		while (dan <= 9) {
			System.out.println();
			System.out.println(dan+"단\n");
			int i = 1;
			while (i <= 9) {
				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
				i++;
			}
			dan++;
		}

	}

}
