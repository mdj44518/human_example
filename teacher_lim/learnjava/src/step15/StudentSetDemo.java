package step15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class StudentSetDemo {
	
	public static void main(String[] args) {
		File file = new File("input123.txt");
		Set<Student> list = new HashSet<> ();

		try {
			Scanner scan = new Scanner(file);
			scan.useLocale(Locale.KOREA);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				
				String tokens[] = line.split(",");
				Student temp = new Student(tokens[0], 
						Integer.parseInt(tokens[1]));
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Student> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		for (Student s : list) {
			System.out.println(s);
		}
		
	}
	

}
