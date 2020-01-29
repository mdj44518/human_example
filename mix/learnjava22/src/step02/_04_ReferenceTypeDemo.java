package step02;

import java.util.Random;

public class _04_ReferenceTypeDemo {

	public static void main(String[] args) {
		String str = "hello";
		String str2 = new String("안녕");
		
		System.out.println(str);
		System.out.println(str2);
		
		int len = str2.length();
		char ch = str2.charAt(0);
		
		System.out.println("Length: " + len);
		System.out.println("0th char: " + ch);
		
		double rand = Math.random();
		System.out.println(rand);
		
		Random random = new Random();
		System.out.println(random.nextInt(32));
	}

}
