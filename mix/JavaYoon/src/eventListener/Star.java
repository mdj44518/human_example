package eventListener;

public class Star {

	public static void main(String[] args) {
		int FLOOR = 7;
		
		boolean turn = true;
		for (int i = 0; i >= 0; i = turn ?  ++i : --i) {
			if (i >= FLOOR-1) turn = false;
			for (int j = FLOOR-i-1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int k = i*2+1; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
