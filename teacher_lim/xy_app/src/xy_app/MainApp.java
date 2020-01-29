package xy_app;

import org.api.dao.DataDAO;

public class MainApp {

	static DataDAO dao;
	
	public static void main(String[] args) {
		Class<?> cls = null;
		System.out.println(args[0]);
		if (args[0].equalsIgnoreCase("oracle")) {
			try {
				cls = Class.forName("org.api.daoimpl.OracleDrv");
				dao = (DataDAO) cls.newInstance();
				System.out.println(dao.doSum(10, 5));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
		}
		
		 

	}
	

}
