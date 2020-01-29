package step12;

import java.io.File;
import java.util.Scanner;

public class ExceptionDemo7 {

	public static void main(String[] args) {
		try {
			loadClass("ABC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void loadClass(String className) throws ClassNotFoundException {
		Class.forName(className);
	}

}
