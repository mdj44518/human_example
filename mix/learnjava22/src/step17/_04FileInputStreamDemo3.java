package step17;

import java.io.FileInputStream;

public class _04FileInputStreamDemo3 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("out.txt");
			byte[] bMsg = new byte[128];
			int len = 0;
			while(true) {
				len = fin.read(bMsg);
				if (len == -1) {
					break;
				}
				String s = new String(bMsg, "UTF-8");
				System.out.print(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
