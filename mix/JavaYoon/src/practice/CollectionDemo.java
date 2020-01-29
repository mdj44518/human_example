package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class CollectionDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1234");
		list.add("12345");
		list.add("12");
		
		String max = list.stream()
						 .max((x,y) -> x.length()-y.length())
						 .get();
		System.out.println(max);
		
//		System.out.println((list.stream()
//								.filter(x -> x.length() == list.stream()
//															   .map(a -> a.length())
//															   .max((z,y) -> z-y)
//								.get()).toArray())[0]);
		
//		System.out.println((list.stream()
//				.anyMatch(x -> x.equals(list.stream()
//											   .map(a -> a.length())
//											   .max((z,y) -> z-y)
//				.get()));
		
//		Set<String> set = new HashSet<String>();
//		set.iterator()
		
		Iterable<String> iter = new Iterable<String>() {
			
			@Override
			public Iterator<String> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		Collections.sort(list);
		

	}

}
