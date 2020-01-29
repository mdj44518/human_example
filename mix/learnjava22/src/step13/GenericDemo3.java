package step13;

public class GenericDemo3 {

 	public static <T> void printArray(T[] arr) {
 		Class<T> c = (Class<T>) arr.getClass();
		System.out.println(c.getSimpleName() + " type array will be printed");
 		for (T element : arr) {
 			System.out.println(element);
 		}
 		System.out.println();
 	}
	
	public static void main(String[] args) {
		Integer[] intArr = {10, 20, 30, 40, 50};
		String[] strArr = {"Java", "PHP", "Python", "C++"};
		
		printArray(intArr);
		GenericDemo3.<String>printArray(strArr);
	}

}
