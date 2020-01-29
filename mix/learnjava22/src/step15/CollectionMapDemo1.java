package step15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionMapDemo1 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<> ();
		
		map.put(100, "홍길동");
		map.put(200, "김무송");
		map.put(300, "이소리");
		
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		for (Map.Entry<Integer, String> e : entrySet) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		System.out.println();
		/*
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		*/

		map.putIfAbsent(400, "박송이");
		map.putIfAbsent(300, "최민수");
		
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		System.out.println();
		
		map.remove(100);
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		System.out.println();
		
		map.replace(400, "박솔일");
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		System.out.println();
		
	}

}
