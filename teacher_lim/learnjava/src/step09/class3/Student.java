package step09.class3;

import java.util.Arrays;

public class Student {
	// 속성 (member variables, attributes, properties)
	String name;
	String id;
	int[] scores;
	
	// 기능 (member methods)
	public void displayInfo() {
		System.out.println(name);
		System.out.println(id);
		System.out.println(Arrays.toString(scores));
	}
}
