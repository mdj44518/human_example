package fileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileReadHangulSuccess {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("c:\\Temp\\hangul.txt");
			InputStreamReader in = new InputStreamReader(fin, "US-ASCII");
			char[] readArr = new char[1024];
			int leng;
			while ((leng = in.read(readArr)) != -1) {
				System.out.println(new String(readArr));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
