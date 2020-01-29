package step12;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		String s = "123s";
		
		try {
			int val = Integer.parseInt(s);
			System.out.println("변환 값: " + val);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		System.out.println("done...");
	}

}
