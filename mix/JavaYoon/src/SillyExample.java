
class SillyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3, b = 0;
		int result;
		try {
		result = a/b;
		System.out.println(result);
		} catch (ArithmeticException | IndexOutOfBoundsException e) {
			System.out.println("잘못된 연산입니다.");
		} finally {
			System.out.println("Done.");
		}
	}

}
