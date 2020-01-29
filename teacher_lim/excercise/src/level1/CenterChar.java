package level1;

public class CenterChar {

	public static void main(String[] args) {
		String input = "qwer";
		
		String center = getCenterStr(input);
		System.out.println(center);
	}

	// 가운데 글자(캐릭터)를 리턴하는 메소드
	// 홀수개의 입력스트링 -> 가운데 캐렉터
	// 짝수개의 입력스트링 --> 가운데 2 케릭터들
	// 입력: String
	// 리턴: String
	// 로직:
	// 		1. 입력스트링 짝수개인지 홀수개인지?
	//      2. 짝수면? 인덱스 = 길이 / 2 - 1
	//      3. 홀수면? 인덱스 = 길이 / 2
	//
	public static String getCenterStr(String str) {
		if (str.length() % 2 == 0) {	// 짝수
			int index = str.length() / 2 - 1;
			return str.substring(index, index + 2);
		} else {	// 홀수
			int index = str.length() / 2;
			return str.substring(index, index + 1);
		}
	}
}






