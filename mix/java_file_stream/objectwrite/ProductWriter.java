package step17.objectwrite;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ProductWriter {

	/*
	 * 샘플 Product 객체 3개를 만들어
	 * 파일(product.dat) 에 저장
	 */
	public static void main(String[] args) {
		Product p = new Product("iPhone");
		p.setSerial("iPhone6s-1324");
		p.setPrice(980.99);
		p.setManDate("2018-12-25");
		p.addReview(6);
		p.addReview(10);
		p.addReview(5);

		//System.out.println(Integer.toBinaryString(100));
		byte[] arr = intToByteArray(300);
		for (int i = 0; i < arr.length; i++) {
			String format = String.format("%8s", Integer.toBinaryString(arr[i] & 0xFF))
					.replace(' ', '0');
			System.out.println(format);
		}
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("product.dat"));
			out.writeObject(p);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static byte[] intToByteArray(int value) {
		return new byte[] {
				(byte)(value >>> 24),
				(byte)(value >>> 16),
				(byte)(value >>> 8),
				(byte)value 
		};
	}

}
