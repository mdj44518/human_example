package step17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class _07BufferedWriterDemo {

	public static void main(String[] args) {
		try {
			FileWriter fwriter = new FileWriter("writer.txt");
			BufferedWriter bWriter = new BufferedWriter(fwriter);
			
			bWriter.write("welcome to buffered writer\n");
			bWriter.write("안녕하세요");
			
			bWriter.close();
			
			System.out.println("writer.txt file written...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
