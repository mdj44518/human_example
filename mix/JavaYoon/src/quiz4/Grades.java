package quiz4;

import java.util.Arrays;
import java.util.Scanner;

public class Grades {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens;
		double result = 0;
		do {
			if (result == -1) System.out.println("정확히 입력바랍니다."); // 반복문 탈출실패시 출력
			System.out.print("학점을 빈칸으로 분리 입력(A/B/C/D/F)>>");
			tokens = scan.nextLine().split("[/||\\s]"); //공백' ' 또는 '/' 기준으로 자름
			result = avg(tokens);
		} while (result == -1);
		System.out.println(tokens.length + "과목 평균은 : " + result);
		scan.close();
	}
	
	static double avg(String[] tokens) {
		long isAlphabetic = Arrays.stream(tokens)
							.filter(x -> x.matches("[A-DFa-df]"))
							.count(); // 정확한 입력값 몇개?
		
		if (tokens.length > 0 && isAlphabetic == tokens.length) {
			return Arrays.stream(tokens)
					.map(String::toUpperCase)
					.mapToDouble(x -> (x.charAt(0) == 'F') ? 0 : ('E' - x.charAt(0)))
					.average().getAsDouble(); // A=4점 , B=3점, C=2점 , D=1점 , F=0점  
		}
		return -1;
	}
}
