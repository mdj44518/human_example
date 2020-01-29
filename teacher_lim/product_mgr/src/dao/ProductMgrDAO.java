package dao;

import java.sql.ResultSet;

import model.Product;
import model.Supplier;

public interface ProductMgrDAO {

	public Product[] getAllProductInfo();
	public Product[] getProductInfoFromPName(String pName);
	
	public int getYearlySalesFromPCode(String pCode);
	public String getSupplierNameFromPCode(String pCode);
	
	public boolean addProduct(Product product);
	public boolean addSupplier(Supplier supplier);
	
	public String getMaxPCodefromPName(String pName);
	public String[] getAllSupplierCodes();
	public String[] getAllCatSupplierCodesFromPName(String pName);
	
	public ResultSet processQuery(String sql);
}
