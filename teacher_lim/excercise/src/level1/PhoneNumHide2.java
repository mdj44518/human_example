package level1;

public class PhoneNumHide2 {

	public static void main(String[] args) {
		String s = "010-3333-4444";
		PhoneNumHide2 p = new PhoneNumHide2();
		System.out.println(p.solution2(s));
	}

	public String solution(String phNum) {
		String lastFour = phNum.substring(phNum.length()-4);
		int replaceNum = phNum.length() - 4;
		String result = "";
		for (int i = 0; i < replaceNum; i++) {
			result += "*";
		}
		
		result += lastFour;
		return result;
	}
	
	public String solution2(String phNum) {
		char[] newPhNum = new char[phNum.length()];
		int startIdx = phNum.length() - 4;
		for (int i = 0; i < phNum.length(); i++) {
			if (i < startIdx) {
				if (Character.isDigit(phNum.charAt(i))) {
					newPhNum[i] = '*';
				} else {
					newPhNum[i] = phNum.charAt(i);
				}
			} else {
				newPhNum[i] = phNum.charAt(i);
			}
		}
		
		return new String(newPhNum);
	}
}
