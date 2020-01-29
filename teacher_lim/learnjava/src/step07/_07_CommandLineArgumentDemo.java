package step07;

public class _07_CommandLineArgumentDemo {

	public static void main(String[] args) {
		for(int i = 0; i<args.length; i++) {
			System.out.println("args[" + i + "]: " +  args[i]);
		}
	}

}
