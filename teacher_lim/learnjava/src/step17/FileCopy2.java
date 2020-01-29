package step17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {
	private static final int READ_CHUNK_NUM = 2048;
	public static void main(String[] args) {
		String inputFileName = "java.png";
		String outputFileName = "java_copy.png";

		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			fin = new FileInputStream(inputFileName);
			fout = new FileOutputStream(outputFileName);

			long curTime = System.nanoTime();
			while (true) {
				byte[] msg = new byte[READ_CHUNK_NUM];
				int readNum = fin.read(msg);

				if (readNum == -1) {
					break;
				}
				fout.write(msg, 0, readNum);
			}
			long finTime = System.nanoTime();
			long diff = (finTime - curTime) / 1000;
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
