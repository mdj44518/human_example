package step09.exercise;

public class StaticDemo {
	// 속성
	int val;
	String name;
	static int code;
	
	// 기능
	public String toString() {
		String result = String.format("%d: %s[%d]", val, name, code);
		return result;
	}
	
	
	public static void main(String[] args ) {
		StaticDemo s1 = new StaticDemo();
		s1.val = 10;
		s1.name = "AAA";
		StaticDemo s2 = new StaticDemo();
		s2.val = 20;
		
		System.out.println(s1);
		System.out.println(s2);
		
		s1.code= 199;
		
		System.out.println(s2.code);
	}
}

