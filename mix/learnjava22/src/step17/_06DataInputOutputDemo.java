package step17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06DataInputOutputDemo {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("data.out");
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(35);
			dout.writeBoolean(true);
			dout.writeUTF("홍길동");
			
			dout.close();
			
			System.out.println("data.out file written");
			
			FileInputStream fin = new FileInputStream("data.out");
			DataInputStream din = new DataInputStream(fin);
			
			int age = din.readInt();
			boolean isMale = din.readBoolean();
			String name = din.readUTF();
			
			System.out.println("나이: " + age);
			System.out.println(isMale == true ? "남자" : "여자");
			System.out.println("성명: " + name);
			
			din.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
