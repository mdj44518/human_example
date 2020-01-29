package step17;

import java.io.FileInputStream;

public class _03FileInputStreamDemo2 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("out.txt");
			int i = 0;
			while(true) {
				i = fin.read();
				if (i == -1) {
					break;
				}
				System.out.print((char)i);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
