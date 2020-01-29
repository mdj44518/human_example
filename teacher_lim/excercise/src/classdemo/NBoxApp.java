package classdemo;

import java.util.Arrays;
import java.util.Random;

public class NBoxApp {

	public static void main(String[] args) {
		NumberBox box = new NumberBox();
		Random random = new Random();
		
		for (int i = 0; i < 100000; i++) {
			box.add(random.nextInt());
		}
		
		for (int i = 0 ; i < 50000; i++) {
			box.remove(random.nextInt());
		}
		
		int[] arr = box.getArray();

		System.out.println(Arrays.toString(arr));
	}

}
