package fileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRederDemo {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("c:\\kor.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
