package step04;

import java.util.Random;

public class _08_BreakContinueDemo2 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				continue;
			} else {
				sum += i * i;
			}
		}
		
		System.out.println("합: " + sum);
	}

}
