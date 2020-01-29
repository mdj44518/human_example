package step04;

import java.util.Random;

public class _07_BreakContinueDemo {

	public static void main(String[] args) {
		// 주사위를 두개 던져 나온 눈이 같을 때까지 수행하는 코드
		Random random = new Random();
		int first = random.nextInt(6) + 1;
		int second = random.nextInt(6) + 1;
		int trial = 1;
		while (true) {
			System.out.println(trial + ": (" 
						+ first + ", " + second + ")");
			
			if (first == second) {
				break;
			}
			
			first = random.nextInt(6) + 1;
			second = random.nextInt(6) + 1;
			trial++;
		}
	}

}
