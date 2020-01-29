import java.io.PrintStream;

class TryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int divisor[] = {5,4,3,2,1,0};
		
		for (int cut = 0; cut < 10; cut++) {
			try {
				int share=100/divisor[cut];
				System.out.println(share);
			}
			catch (ArithmeticException e) {
				e.printStackTrace();
			}
			catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done.");
	}

}
