package step06;

import java.util.Arrays;

public class _02_ArrayDemo2 {

	public static void main(String[] args) {
		String[][] persons = {
				{"이기동", "30", "서울시"},
				{"김새롬", "35", "수원시"},
				{"박준석", "15", "인천시"},
				{"임지택", "10", "천안시"}
		};
		
		// 모든 사람 정보 출력
		for (int i = 0; i < persons.length; i++) {
			System.out.println(i + "번째 ...");
			for (int j = 0; j < persons[i].length; j++) {
				System.out.print(persons[i][j] + " ");
			}
			System.out.println();
		}
		
		// 알파벳 저장 및 출력 (5행 4열)
		int startCh = 'a';
		char[][] alphabets = new char[5][4];
		for (int i = 0; i < alphabets.length; i++) {
			for (int j = 0; j < alphabets[i].length; j++) {
				alphabets[i][j] = (char)startCh;
				startCh += 1;
			}
		}
		
		for (int i = 0; i < alphabets.length; i++) {
			for (int j = 0; j < alphabets[i].length; j++) {
				System.out.print(alphabets[i][j] + " ");
			}
			System.out.println();
		}

		
		double[][] scores = new double[5][];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = new double[i * 2 + 1];
		}
		
		// scores 배열은 어떤 모습일까?
		String[][] info = new String[4][];
		info[0] = new String[4];
		info[0][0] = "abc";
		
	}

}
