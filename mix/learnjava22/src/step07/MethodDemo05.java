package step07;

public class MethodDemo05 {

	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(isNumber(str));
		System.out.println(isNumber("12aa"));
		System.out.println(isNumber(""));
		System.out.println(isNumber(null));
	}
	
	// String을 입력받아 해당스트링이 모두 숫자로 되어
	// 있는지를 체크하는 함수
	// 예) "123" --> true
	//     "12b3" --> false
	//     ""  --> ? false
	//     null --> ? false
	// method signature
	// 로직:
	//  입력받은 스트링에 캐릭터들을 하나씩 검사
	//     숫자가 아닌 캐릭터이면 --> return false
	//  반복문 종료
	//  return true
	public static boolean isNumber(String str) {
		if (str == null) {
			return false;
		}
		
		if (str.length() == 0) {
			return false;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}

}
