package step17;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class _05BufferedOutputDemo {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("buffer_out.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			String s = "Hello Java!";
			byte[] bMsg = s.getBytes();
			
			bout.write(bMsg);
			bout.close();
			fout.close();
			
			System.out.println("buffered_out.txt file written");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
