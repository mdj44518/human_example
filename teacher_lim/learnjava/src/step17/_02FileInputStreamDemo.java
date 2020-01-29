package step17;

import java.io.FileInputStream;

public class _02FileInputStreamDemo {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("out.txt");
			int i = fin.read();
			System.out.println((char)i);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
