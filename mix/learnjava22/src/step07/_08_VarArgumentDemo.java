package step07;

public class _08_VarArgumentDemo {

	public static void main(String[] args) {
		printMax(10.5, 4.45, -9.12);
		printMax(new double[] {3, 5, 2, 11, 8});
	}
	
	public static void printMax(double... numbers) {
		if (numbers.length == 0) {
			System.out.println("No arguments passed");
			return;
		}
		
		double max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		System.out.println("최대값: " + max);
	}

}
