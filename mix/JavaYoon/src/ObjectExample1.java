import java.util.Scanner;

class ObjectExample1 {

	public static void main(String[] args) {
		StringBuffer obj;
		obj = new StringBuffer("Hey, Java");
		obj.delete(1, 2).deleteCharAt(1).insert(1, 'i');
		System.out.println(obj);
		
		

	}

}
