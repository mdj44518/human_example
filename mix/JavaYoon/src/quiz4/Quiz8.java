package quiz4;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class Quiz8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		Map<String, Integer> map = new HashMap<>();
		System.out.println("** 포인트 관리 프로그램입니다 **");
		String input;
		Set<String> key2;
//		do {
//			System.out.print("이름과 포인트 입력>> ");
//			input = scan.nextLine();
//			String[] tokens = input.split(" ");
//			int point = Integer.parseInt(tokens[1]);
//			map.compute(tokens[0], (k,val) -> map.containsKey(k) ? val+point : point);
//			key = map.keySet();
////			key.forEach(x -> map.get(x));
//		} while (!input.equals("그만"));
		
//		map.computeIfPresent(key, remappingFunction);
		
		
		Map<String, Integer> map = new HashMap<>();
		
		map.compute("키값", (k,val) -> map.containsKey(k) ? val+99 : 99);//무조건 계산.
		
		map.computeIfPresent("키값", (k,val) -> val+99);//키값으로 데이터가 있으면 계산 true
		map.computeIfAbsent("키값", k -> map.put(k, 99));//키값으로 데이터가 없으면 계산 false 로 알아서 if만들어쓰기
		
		// 위 두가지 방법은 "99" 란 값을 데이터로 저장할때 주는 키값이 기존에 있다면 그 안에 value를 지금 들어가는 99랑 더해서 넣고
		// 없다면 해당 키값으로 새로운 데이터의 "99" 를 넣는다 
		
		
		
		
//		System.out.println(map.putIfAbsent("이재문", 999));
//		System.out.println(map.put("이재문", 11));//60
		
		Set<String> key = map.keySet();
		for (String k : key) {
			System.out.println(k +" : " +map.get(k));//11
		}
//		System.out.println(map.get("이재광"));
		
		//한번에 하는거 읍나..
//		int[] arr = {1,2,3,4};
//		Arrays.stream(arr).reduce(op)
//		IntBinaryOperator binaryOper = new IntBinaryOperator() {
//
//			@Override
//			public int applyAsInt(int left, int right) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		};
//		
//		in.capacity()
		
		
	}

}


//Function<String,Integer> fun = new Function<String,Integer>() {
//
//	@Override
//	public Integer apply(String t) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//};