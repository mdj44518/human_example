package step12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckExceptionDemo {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("test.txt");
			int i = fin.read();
			System.out.println((char)i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
