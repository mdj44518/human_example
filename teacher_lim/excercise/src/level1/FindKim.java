package level1;

import java.util.Arrays;

public class FindKim {

	public static void main(String[] args) {
		String[] input = {"aaa", "kim"};
		System.out.println(findKim(input));
		
		input[1] = new String("kim");
		System.out.println(Arrays.toString(input));
		System.out.println(findKim(input));
	}
	
	public static String findKim(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equalsIgnoreCase("kim")) {
			//if (names[i] == "kim") {
				return "김서방은 " + i + "에 있다";
			}
		}
		return null;
	}

}
