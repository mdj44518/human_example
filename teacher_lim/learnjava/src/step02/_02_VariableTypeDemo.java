package step02;

public class _02_VariableTypeDemo {

	public static void main(String[] args) {
		// 기본(Primitives)
		int var01 = 150;
		long var02 = 234234L;
		
		byte var03 = 4;
		short var04 = 25;
		char var05 = 'a';
		
		boolean var06 = 10 > 5;
		
		System.out.println(var01);
		System.out.println(var02);
		System.out.println(var03);
		System.out.println(var04);
		System.out.println(var05);
		System.out.println(var06);
		
		// 참조형(Reference)
		String message = "안녕하세요";
		char[] greet = {'반', '갑', '습', '니', '다'};
		
		System.out.println(message);
		System.out.println(greet);
	}

}
