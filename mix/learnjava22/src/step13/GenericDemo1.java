package step13;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo1 {

	public static void main(String[] args) {
		// Old version without generic
		List list = new ArrayList();
		list.add("hello");
		list.add(12);
		
		String msg = (String)list.get(0);
		int value = (int)list.get(1);
		
		System.out.println(msg);
		System.out.println(value);
		
		// with generic
		List<String> newList = new ArrayList<> ();
		newList.add("홍길동");
		// newList.add(13);
		newList.add("정훈");
		
		for (String s : newList) {
			System.out.println(s);
		}
	}

}
