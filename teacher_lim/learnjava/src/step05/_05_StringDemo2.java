package step05;

import java.util.Arrays;

public class _05_StringDemo2 {

	public static void main(String[] args) {
		String str = "123/45/80/67/100";
		
		//"123", "45", "85", "67", "100"
		String[] values = str.split("/");
		
		System.out.println(Arrays.toString(values));
		
		str = "10,   20,30,       40, 50";
		// "10", "20", "30", ...
		values = str.split(", ");
		System.out.println(Arrays.toString(values));
		
		// 정규표현식
		// , 에 이어서 공백문자가 0개 혹은 그 이상의 개수만큼 오는 패턴을 규정
		values = str.split(",\\s*");
		System.out.println(Arrays.toString(values));
	}

}
