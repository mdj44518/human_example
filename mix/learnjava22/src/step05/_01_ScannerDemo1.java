package step05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _01_ScannerDemo1 {

	public static void main(String[] args) throws FileNotFoundException  {
		Scanner scanner = new Scanner(new File("test.txt"));
			
		while (scanner.hasNext()) {
			String word = scanner.next();
			System.out.println(word);
		}
	
	}

}
