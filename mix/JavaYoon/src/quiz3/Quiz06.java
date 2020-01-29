package quiz3;

import java.util.Calendar;
import java.util.Scanner;
import static java.lang.Math.abs;

public class Quiz06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
		System.out.print("황기태 시작 <Enter>키>>");
		scan.nextLine();
		int p1_before = Calendar.getInstance().get(Calendar.SECOND);
		System.out.println("\t현재 초 시간 = " + p1_before);
		System.out.print("10초 예상후 <Enter>키>>");
		scan.nextLine();
		int p1_after = Calendar.getInstance().get(Calendar.SECOND);
		System.out.println("\t현재 초 시간 = " + p1_after);
		
		System.out.print("이재문 시작 <Enter>키>>");
		scan.nextLine();
		int p2_before = Calendar.getInstance().get(Calendar.SECOND);
		
		
		System.out.println("\t현재 초 시간 = " + p2_before);
		System.out.print("10초 예상후 <Enter>키>>");
		scan.nextLine();
		int p2_after = Calendar.getInstance().get(Calendar.SECOND);
		System.out.println("\t현재 초 시간 = " + p2_after);
		
		// 연산 어떻게?
		int p1_result = p1_after - p1_before;
		int p2_result = p2_after - p2_before;
		if (p1_result < 0) p1_result += 60;
		if (p2_result < 0) p2_result += 60;
		
		// - 10 했을때 더 가까운놈?
		String result = "";
		if (abs(p1_result-10) < abs(p2_result-10)) result = "승자는 황기태";
		else if (abs(p1_result-10) == abs(p2_result-10)) result ="무승부입니다";
		else result = "승자는 이재문";
		System.out.println("황기태의 결과 " + p1_result + ", 이재문의 결과 " + p2_result + ", " + result);
		
	}

}
