package step17;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
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
		Product p = new Product("pony");
		p.setManDate("2019-04-15");
		p.setPrice(29.99);
		p.setSerial("p-01-1234");
		p.addReview(10);
		p.addReview(5);
		p.addReview(7);
		
		//System.out.println(p.getMandateString());
	
		//System.out.println(p);
		FileOutputStream fout;
		/*
		 * 1. 상품이름
		 * 2. 시리얼넘버
		 * 3. price
		 * 4. 제조일자
		 * 5. reviews
		 *    reviews의 갯수(0)
		 *    reivew의 값
		 *    reivew의 값
		 *    ...
		 */
		try {
			fout = new FileOutputStream("product.dat");
			DataOutputStream out = new DataOutputStream(fout);
			
			out.writeUTF(p.getName());
			out.writeUTF(p.getSerial());
			out.writeDouble(p.getPrice());
			out.writeUTF(p.getMandateString());
			int[] reviews = p.getReviews();
			out.writeInt(reviews.length);
			for (int i = 0; i < reviews.length; i++) {
				out.writeInt(reviews[i]);
			}
			
			System.out.println(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
