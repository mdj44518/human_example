package step07;

import java.util.Scanner;

public class MethodDemo03 {

	/*
	 * 주말 숙제:
	 * 파일을 읽어 단어가 몇개인지 출력하고,
	 * 검색하는 프로그램작성
	 * 
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] dict = new String[2000];
		
		String line = scan.nextLine();
		
		String[] tokens = line.split("\\.|\\?|!|\"|\\s+");
//		for (int i = 0; i < tokens.length; i++) {
//			System.out.println(i + ": |" + tokens[i] + "|");
//		}
		
		// 오른쪽: iterable object
		for (String str : tokens) {
			System.out.println("|" + str + "|");
		}
		
		addTokens(dict, tokens);
 	}

	private static void addTokens(String[] repo, String[] tokens) {
		for (int i = 0; i < tokens.length; i++) {
			repo[i] = tokens[i];
		}
	}

}
