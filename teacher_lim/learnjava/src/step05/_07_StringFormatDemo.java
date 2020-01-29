package step05;

public class _07_StringFormatDemo {

	public static void main(String[] args) {
		String name = "홍길동";
		int age = 30;
		char gender = 'M';
		int money = 1234567;
		
		String output = String.format("Name:%5s\nAge:%4d\nGender:%3c\nMoney:$%,d\n", name, age, gender, money);
		System.out.println(output);
		
		double value = 123.4567;
		System.out.printf("value:|%10.3f|", value);
		System.out.println();
		System.out.printf("value:|%010.3f|", value);
		System.out.println();
		System.out.printf("value:|%-10.3f|", value);
	}

}
