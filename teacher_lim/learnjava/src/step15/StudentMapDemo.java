package step15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentMapDemo {
	
	public static void main(String[] args) {
		File file = new File("input123.txt");
		Map<String, Student> map = new HashMap<> ();

		try {
			Scanner scan = new Scanner(file);
			scan.useLocale(Locale.KOREA);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				
				String tokens[] = line.split(",");
				Student temp = new Student(tokens[0], 
						Integer.parseInt(tokens[1]));
				map.put(tokens[0], temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String name : map.keySet()) {
			System.out.println(name + " --> " + map.get(name));
		}
		
	}
	

}
