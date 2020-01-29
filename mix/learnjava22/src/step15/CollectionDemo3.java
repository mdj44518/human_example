package step15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionDemo3 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<> ();

		list.add("중구");
		list.add("마포구");
		list.add("용산구");
		
		System.out.println(list);
		
		list.add(1, "은평구");
		System.out.println(list);
		
		List<String> list2 = new LinkedList<>();
		list2.add("강남구");
		list2.add("서초구");
		
		list.addAll(list2);
		System.out.println(list);
		
		String item = list.remove(1);
		System.out.println(list);
		System.out.println("삭제한 구: " + item);
		
		list.remove("서초구");
		System.out.println(list);
		
		String[] arr = list.toArray(new String[0]);
		System.out.println(Arrays.toString(arr));
	}
 
}
