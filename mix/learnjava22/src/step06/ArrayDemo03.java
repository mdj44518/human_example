package step06;

import java.util.Scanner;

/*
 * 데이터 형식
 * 이름 전화번호 성별(m/f) 나이
 * 임지택 010-111-2222 m 10
 * 10 개의 데이터
 * 
 * 적절한 배열에 저장하고,
 * 절적한 포맷으로 출력하고,
 * 
 * *******
 * 나이순으로 정렬해서 출력
 * *******
 */
public class ArrayDemo03 {

	public static void main(String[] args) {
		String[][] info = new String[10][3];
		int[] age = new int[10];

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < info.length; i++) {
			for (int j = 0; j < info[i].length; j++) {
				info[i][j] = scan.next();
			}
			age[i] = scan.nextInt();
		}

		// deep copy
		String[][] info_copy = new String[info.length][3];
		for (int i = 0; i < info_copy.length; i++) {
			// target: info_copy[i]
			// org: info[i]
			System.arraycopy(info[i], 0, info_copy[i], 0, info[i].length);
 		}
		int[] age_copy = new int[10];
		System.arraycopy(age, 0, age_copy, 0, age.length);
		
		System.out.println("정렬전....");
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i][0] + "  " + info[i][1] 
					+ "  " + info[i][2] + "  " + age[i]);
		}
		System.out.println();
		
		
		// 정렬
		for (int i = 0; i < age.length - 1; i++) {
			for (int j = 0; j < age.length - 1 - i; j++) {
				if (age[j] > age[j+1]) { // swap
					int temp = age[j];
					age[j] = age[j+1];
					age[j+1] = temp;
					
					// KEY!!!!
					// info[j]와 info[j+1] swap
					String[] tempInfo = info[j];
					info[j] = info[j+1];
					info[j+1] = tempInfo;
				}
			}
		}
		
		System.out.println("정렬후....");
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i][0] + "  " + info[i][1] 
					+ "  " + info[i][2] + "  " + age[i]);
		}
		System.out.println();
		
		System.out.println("원본정렬....");
		for (int i = 0; i < info_copy.length; i++) {
			System.out.println(info_copy[i][0] + "  " + info_copy[i][1] 
					+ "  " + info_copy[i][2] + "  " + age_copy[i]);
		}
	}

}
