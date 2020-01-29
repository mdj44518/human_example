package practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RectMain {

	public static void main(String[] args) {
		Method[] mm = Math.class.getMethods();
		System.out.println();
//		System.out.println(Arrays.toString(mm));
//		for (Method m : mm) {
//			System.out.println(m.getName());
//		}
		try {
			System.out.println(mm[0].getParameterTypes()[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
//	public static void main(String[] args) {
//		Rectangle r = new Rectangle(2,2,8,7);
//		Rectangle s = new Rectangle(0,0,2,3);
//		Rectangle t = new Rectangle(-4,3,10,8);
//		
//		r.show();
//		System.out.println("s의 면적은 " + s.square());
////		System.out.println(t.contains(s));
//		
//		
//	}

}
