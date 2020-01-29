package fileIO;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedIOEx {

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
		
		try {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
