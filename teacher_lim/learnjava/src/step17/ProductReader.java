package step17;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProductReader {

	/*
	 * 상품 파일(product.dat)을 읽어
	 * Product 객체를 생성하여 콘솔에 찍어보세요
	 * 
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
	public static void main(String[] args) {
		FileInputStream fin;
		Product p = new Product("dummy");
		try {
			fin = new FileInputStream("product.dat");
			DataInputStream in = new DataInputStream(fin);
			
			p.setName(in.readUTF());
			p.setSerial(in.readUTF());
			p.setPrice(in.readDouble());
			p.setManDate(in.readUTF());
			int numOfReviews = in.readInt();
			for (int i = 0; i < numOfReviews; i++) {
				p.addReview(in.readInt());
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

}
