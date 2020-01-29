package quiz5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Quiz5_5 {

	public static void main(String[] args) {
		// 파일 두개 비교하기
		String be = "C:\\Temp\\img.jpg";
		String af = "C:\\Temp\\img2.jpg";
		try {
			FileInputStream in1 = new FileInputStream(be);
			FileInputStream in2 = new FileInputStream(af);
			boolean result = true;
			int n1 = -1, n2 = -1;
			while ((n1 = in1.read()) != -1) {
				if ((n2 = in2.read()) != -1 && n1 == n2) {
					
				} else {
					result = false;
				}
				if (!result) break;
			}
			if (result && n2 != -1) { 
				if ((n2 = in2.read()) != -1) result = false;
			}
			if (result) {
				System.out.println("같다");
			} else {
				System.out.println("다르다");
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
