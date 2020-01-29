package app;

import java.util.Arrays;
import java.util.Random;

import dao.ProductMgrDAO;
import dao.ProductMgrDAOImpl;
import model.Product;
import model.ProductType;

public class ProductMgrMain {
	
	public static void main(String[] args) {
		ProductMgrDAO dao = new ProductMgrDAOImpl();
		/*
		

		Product[] products = dao.getAllProductInfo();
		
		System.out.println(Arrays.toString(products));
		System.out.println();
	
		products = dao.getProductInfoFromPName("냉장고");
		System.out.println(Arrays.toString(products));
		System.out.println();
		int sum = dao.getYearlySalesFromPCode("FAN-003");
		System.out.println("FAN-003: " + sum);
		
		String supplierName = dao.getSupplierNameFromPCode("FAN-002");
		System.out.println("FAN-002 제조사: " + supplierName);
		
		Product p = new Product();
		p.setpName("에어콘");
		p.setpCode("AIR-005");
		p.setFirstQ(50);
		p.setSecondQ(40);
		p.setThirdQ(80);
		p.setFourthQ(60);
		p.setSupCode("CE-003");
		*/
		
		/*
		ProductType[] types = ProductType.values();
		Random random = new Random();
		int pick = random.nextInt(types.length);
		
		System.out.println("상품명: " + types[pick].getProductName());
		System.out.println("상품코드: " + String.valueOf(types[pick]));
		*/
		
//		Product product = ProductMgrUtil.getNewProduct();
//		System.out.println(product);
		
		for (int i = 0; i < 10; i++ ) {
			Product product = ProductMgrUtil.getNewProduct();
			
			if (dao.addProduct(product)) {
				System.out.println(product.getpName() + " 상품 추가 성공");
				
				/*
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
			}
		}
		
		
	}

}
