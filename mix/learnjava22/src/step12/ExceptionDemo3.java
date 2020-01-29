package step12;

public class ExceptionDemo3 {

	public static void main(String[] args) {
		try {
			int a[] = new int[5];
			//a[5] = 30 / 0;
			a[5] = 30 / 1;
			System.out.println(a[10]);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("done...");
	}

}
