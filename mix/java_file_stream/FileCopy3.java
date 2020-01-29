package step17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy3 {
	private static final int READ_CHUNK_NUM = 2048;
	public static void main(String[] args) {
		String inputFileName = "java.png";
		String outputFileName = "java_copy.png";

		FileInputStream fin = null;
		FileOutputStream fout = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		try {
			fin = new FileInputStream(inputFileName);
			fout = new FileOutputStream(outputFileName);
			bin = new BufferedInputStream(fin);
			bout = new BufferedOutputStream(fout);
			
			long curTime = System.nanoTime();
			while (true) {
				byte[] msg = new byte[READ_CHUNK_NUM];
				int readBytes = bin.read(msg);
				
				if (readBytes == -1) {
					break;
				}
				
				bout.write(msg, 0, readBytes);
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
