package step05;

import java.util.Scanner;

public class StringDemo01 {

	/*  
	 * 사용자로 부터 전화번호를 입력 받아,
	 * 지역을 알아내세요
	 * 
	 * 02-585-7971   -> 서울
	 * 031-444-2222  -> 경기
	 * 032-111-1111  -> 인천
	 * 044-222-1234  -> 충북
	 * 055-555-7777  -> 경남
	 * 
	 * 010-999-1234  -> 모바일
	 * 
	 * 그외 --> 몰라
	 */
	public static void main(String[] args) {
		System.out.print("전화번호 입력");
		Scanner scan = new Scanner(System.in);
		String phNum = scan.nextLine();
		phNum = phNum.trim();
		
		// 지역번호 추출
		// 1. '-' 위치
		int foundIdx = phNum.indexOf('-');
		if (foundIdx == -1) {
			System.out.println("잘못된 형식의 전화번호입니다.");
			//return;
			System.exit(0);
		} else {
			// 2. 전화번호 지역번호 추출
			String areaCode = phNum.substring(0, foundIdx);
			
			switch (areaCode) {
			case "02":
				System.out.println(phNum + ", 서울지역입니다.");
				break;
			case "031":
				System.out.println(phNum + ", 경지지역입니다.");
				break;
			case "032":
				System.out.println(phNum + ", 인천지역입니다.");
				break;
			case "044":
				System.out.println(phNum + ", 충북지역입니다.");
				break;
			case "055":
				System.out.println(phNum + ", 경남지역입니다.");
				break;
			case "010":
				System.out.println(phNum + ", 모바일입니다.");
				break;
			default:
				System.out.println("글세요");
				break;
			}
		}
	}

}






