package step03;

public class _02_EqualityDemo {

	public static void main(String[] args) {
		int var = 10;
		double var2 = 10;

		if (var == 10) {
			System.out.println("Var 변수는 10입니다.");
		}
		
		if (var == var2) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
		
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		System.out.println("str3: " + str3);
		
		if (str1 == str2) {
			System.out.println("str1 == str2");
		} else {
			System.out.println("str1 != str2");
		}
		
		if (str1 == str3) {
			System.out.println("str1 == str3");
		} else {
			System.out.println("str1 != str3");
		}
		
		if (str1.equals(str3)) {
			System.out.println("str1의 속성 == str3의 속성");
		} else {
			System.out.println("str1의 속성 != str3의 속성");
		}

	}

}
