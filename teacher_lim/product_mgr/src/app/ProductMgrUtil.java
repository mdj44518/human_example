package app;

import java.util.Arrays;
import java.util.Random;

import dao.ProductMgrDAO;
import dao.ProductMgrDAOImpl;
import model.Product;
import model.ProductType;

public class ProductMgrUtil {

	private static final int QUATER_SALES_BOUND = 200;
	
	public static Product getNewProduct() {
		// 변수
		//   --> 값을 저장
		// identifier(식별자)
		// 절대 객체 아님.
		// 참조형 변수
		//   --> 값을 저장
		//   --> 무슨 값????
		//   --> 참조할수 있는 값  --> 주소
		Product product = new Product();
		String productName;
		String productCode;
		int[] quaterSales = new int[4];
		String supplierCode;
		
		// 상품정보 주입
		// . 상품이름
		ProductType[] types = ProductType.values();
		
		// 랜덤 값을 정한다. (types배열의 크기)
		Random random = new Random();
		int pick = random.nextInt(types.length);
		
		// 선택된 상품타입 객체
		productName = types[pick].getProductName();
		String proCodePrefix = types[pick].toString();
		
		ProductMgrDAO dao = new ProductMgrDAOImpl();
		/*
		String maxPCode = dao.getMaxPCodefromPName(productName);
		
		int proCodePostfix = Integer.parseInt(maxPCode.split("-")[1]) + 1;
		
		productCode = proCodePrefix + "-" + proCodePostfix;
		*/
		for (int i = 0; i < quaterSales.length; i++) {
			quaterSales[i] = random.nextInt(QUATER_SALES_BOUND);
		}
		
		String[] sCodes = dao.getAllCatSupplierCodesFromPName(productName);
		System.out.println(Arrays.toString(sCodes));
		pick = random.nextInt(sCodes.length);
		
		supplierCode = sCodes[pick];
		
		//System.out.println(productCode);
		product.setpName(productName);
		//product.setpCode(productCode);
		product.setFirstQ(quaterSales[0]);
		product.setSecondQ(quaterSales[1]);
		product.setThirdQ(quaterSales[2]);
		product.setFourthQ(quaterSales[3]);
		product.setSupCode(supplierCode);
		
		return product;
	}
}
