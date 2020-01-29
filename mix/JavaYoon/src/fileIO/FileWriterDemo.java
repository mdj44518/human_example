package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FileWriter fw = null;
		try {
			fw = new FileWriter("c:\\Temp\\testmoon.txt");
			while (true) {
				String str = scan.nextLine();
				if (str.equals("")) break;
				fw.write(str+"\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
