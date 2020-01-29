package level1;

import java.util.Arrays;

public class PhoneNumHide {

	public static void main(String[] args) {
		String s = "01033334444";
		PhoneNumHide p = new PhoneNumHide();
		System.out.println(p.solution(s));
	}

	public String solution(String phNum) {
		String result = "";
		int startIndex = phNum.length() - 4;
		for (int i = 0; i < phNum.length(); i++) {
			if (i < startIndex) {
				result += "*";
			} else {
				result += phNum.charAt(i);
			}
		}
		return result;
	}

}
