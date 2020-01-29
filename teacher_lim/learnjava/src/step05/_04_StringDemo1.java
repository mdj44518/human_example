package step05;

public class _04_StringDemo1 {

	public static void main(String[] args) {
		String str = "Java Easy";
		String str2 = new String("hello");

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		// Easy 부분 문자열 추출
		System.out.println(str.substring(5));
		// Java 부분 문자열 추출
		System.out.println(str.substring(0, 4));
		
		str2 = "스텝5 기본적클라스";
		if (str2.contains("기본")) {
			System.out.println("기본이 들어간 문자열입니다.");
		}
		
		str2 = "I will study java really hard, but java isn't easy though";
		String newStr = str2.replace("java", "Java");
		
		System.out.println("old: " + str2);
		System.out.println("new: " + newStr);
	}

}
