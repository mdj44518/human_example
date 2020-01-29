package quiz4_2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class WordQuiz2 {
	public static void main(String[] args) {

		Vector<Word> wordBook = new Vector<>();

		wordBook.add(new Word("painting","그림"));
		wordBook.add(new Word("bear","곰"));
		wordBook.add(new Word("eye","눈"));
		wordBook.add(new Word("society","사회"));
		wordBook.add(new Word("love","사랑"));
		wordBook.add(new Word("animal","동물"));
		wordBook.add(new Word("inheritance","상속"));
		wordBook.add(new Word("polymorphism","다형성"));
		wordBook.add(new Word("reference","참고"));
		wordBook.add(new Word("exception","예외"));

		int wordBookSize = wordBook.size();
		System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.printf("현재 %,d개의 단어가 들어 있습니다.\n\n", wordBookSize);

		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		final int VIEW_LIST_NUM = 4;

		//시작
		while (true) {
			int answerIdx = random.nextInt(wordBookSize);//정답삼을놈 index선택
			Vector<Integer> xIndex = new Vector<>(); // 고르면 안되는 index 정보 저장
			xIndex.add(answerIdx);
			int answer = random.nextInt(VIEW_LIST_NUM) + 1;//정답을 배치할곳 선택 1~4 == 추후 정답과 비교

			
			//문제 제출
			System.out.println(wordBook.get(answerIdx).eng);

			for (int i = 1; i <= VIEW_LIST_NUM; i++) {
				int idx;
				if (i == answer) idx = answerIdx;
				else {
					do idx = random.nextInt(wordBookSize);
					while (xIndex.contains(idx));
					xIndex.add(idx);
				}
				System.out.print("("+i+")"+ wordBook.get(idx).kor +" ");
			}
			System.out.print(":>>"); //문제 제출 끝

			
			int userChoice = scan.nextInt(); //정답 받기
			if (userChoice == -1) break;
			System.err.println(userChoice == answer ? "정답\n" : "오답\n");
		}


		System.out.println("프로그램을 종료합니다..");
		scan.close();
	}
}