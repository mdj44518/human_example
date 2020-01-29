package step15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionSetDemo1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Two");
		set.add("Four");
		set.add("One");
		set.add("Five");

		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
