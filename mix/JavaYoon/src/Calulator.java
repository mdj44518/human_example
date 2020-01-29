import java.util.Scanner;

class Calulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("두 수 입력 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println("두수의 합:"+add(num1,num2));
		System.out.println("두수의 몫:"+div(num1,num2));
		
	    scan.close();
	}


	private static int add(int i, int j) {
		return i + j;
	}
	
	private static int div(int i, int j) {
		int result = 0;
		try {
			result = i / j;
		} catch (ArithmeticException e) {
			System.err.println("산술연산 예외발생");
		}
		return result;
	}
	
}
