package step05;

public class _06_StringDemo3 {

	public static void main(String[] args) {
		String phoneNum = "123-456-7890";
		
		int index = phoneNum.indexOf('-');
		System.out.println("- found at " + index);
		
		// 모든 - 찾는 법
		phoneNum = "123-456-7890-";
		System.out.println("searching \'-\' from " + phoneNum);
		index = 0;
		while (true) {
			int foundIdx = phoneNum.indexOf('-', index);
			
			if (foundIdx == -1) {
				break;
			}
			
			System.out.println("- found at " + foundIdx);
			
			if (foundIdx != phoneNum.length() - 1) {
				index = foundIdx + 1;
			} else {
				break;
			}
			
		}

	}

}
