package step17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		String inputFileName = "java.png";
		String outputFileName = "java_copy.png";

		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			fin = new FileInputStream(inputFileName);
			fout = new FileOutputStream(outputFileName);

			long curTime = System.currentTimeMillis();
			while (true) {
				int b = fin.read();

				if (b == -1) {
					break;
				}
				fout.write(b);
			}
			long finTime = System.currentTimeMillis();
			long diff = finTime - curTime;
			System.out.println(outputFileName + " was written (" + diff + ")");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fin != null)
					fin.close();
				if (fout != null)
					fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
