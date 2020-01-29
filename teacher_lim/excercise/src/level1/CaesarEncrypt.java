package level1;

public class CaesarEncrypt {

	public static void main(String[] args) {
		String a = "z";
		CaesarEncrypt c = new CaesarEncrypt();
		System.out.println(c.solution(a, 25));
	}

	/*
	 * "ABC" -> ['A', 'B', 'C']
	 * 
	 *   'Y'(89) + 5 = '^'(94-26) --> 'D' (68)
	 */
	public String solution(String s, int n) {
		// String --> char[]
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (isAlphabetic(arr[i])) {
				int ch = arr[i] + n;
				if (!isAlphabetic((char)ch)) {
					ch = ch - 26;
				}
				arr[i] = (char)ch;
			}
		}
		return String.valueOf(arr);
	}
	
	public boolean isAlphabetic(char ch) {
		if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			return true;
		} else {
			return false;
		}
	}
}
