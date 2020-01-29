package step15;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<> ();
		
		list.add("서울");
		list.add("부산");
		list.add("대전");
		list.add("광주");

		System.out.println(list);
	}

}
