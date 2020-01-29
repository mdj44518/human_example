package step15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionDemo2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<> ();
		
		list.add(15);
		list.add(20);
		list.add(5);
		list.add(30);
		
		// Iterator를 통한 순회
		//Iterator iter = list.iterator();
		Iterator<Integer> iter = list.iterator();
		System.out.println("Iterator객체를 이용");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		// advanced for-loop
		System.out.println("향상된 for");
		for (Integer value : list) {
			System.out.println(value);
		}
		System.out.println();
		
		System.out.println("전통적인 for");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
