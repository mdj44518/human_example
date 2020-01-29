package step17;

import java.io.File;

public class _09FileDemo {

	public static void main(String[] args) {
		try {
			File file = new File("java123.txt");
			if (file.createNewFile()) {
				System.out.println("new file created");
			} else {
				System.out.println("alread exists");
			}
			
			String path = file.getAbsolutePath();
			System.out.println("절대경로: " + path);
			
			File file2 = new File("C:/Users/jitaek");
			/*
			String fileNames[] = file2.list();
			for (String f : fileNames) {
				System.out.println(f);
				
			}
			*/
			File[] files = file2.listFiles();
			for (File f : files) {
				System.out.println(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
