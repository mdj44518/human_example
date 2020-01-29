package fileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
			FileInputStream fin = null;
			
			for (int i = 0; i <10; i++) {
				int n = 10-i;
				fout.write(n);
			}
			fout.close();
			
			fin = new FileInputStream("c:\\Temp\\test.out");
			int c;
			while ((c = fin.read()) != -1) {
				System.out.print((byte)c + " ");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
