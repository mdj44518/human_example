package quiz5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Quiz5_4 {

	public static void main(String[] args) {
		// 읽어와서 출력 system.ini
		try {
			FileReader fr = new FileReader("C:\\Windows\\system.ini");
			BufferedReader breader = new BufferedReader(fr);
			int i = 1;
			while (breader.ready()) {
				System.out.printf("%2d: %s\n",i++,breader.readLine());
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
