package step17;

import java.io.FileOutputStream;

public class _01FileOutputStreamDemo {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("out.txt");
			fout.write(65);
			fout.write(66);
			fout.write(67);
			//fout.write(12);
			fout.write(13);
			
			String m = "Welcome to Java\n";
			byte[] bMsg = m.getBytes();
			fout.write(bMsg);
			
			m = "반갑습니다 자바";
			bMsg = m.getBytes();
			fout.write(bMsg, 0, bMsg.length);
			fout.close();
			
			System.out.println("file wrote ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("program end");
	}

}
