package quiz4_2;

import java.util.Scanner;
import java.util.Vector;

public class WordQuiz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Vector<Word> wordBook = new Vector<>();
		for (int i = 0; i < 30000; i++) {
			
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
		}

		System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 "+wordBook.size()+"의 단어가 들어 있습니다.");
		
		
		int userChoice;
		final int VIEW_LIST_NUM = 4;
		long startTime = System.nanoTime();
		do {
		Vector<Word> quizList = new Vector<>(wordBook);//복사 하기
		
		Word[] viewList = new Word[VIEW_LIST_NUM];
		for (int i = 0; i < viewList.length; i++) {// viewList에 랜덤 넣기
			int removeIdx = (int)(Math.random()*quizList.size());
			viewList[i] = quizList.remove(removeIdx);
		}
		
		int resultIdx = (int)(Math.random()*VIEW_LIST_NUM); // 0~3 발생
		System.out.println(viewList[resultIdx].eng);//정답 인덱스 저장해두고, 문제 제출
		
		for (int i = 0; i < viewList.length; i++) {// viewList 양식에 맞게 출력
			System.out.print("("+(i+1)+")"+viewList[i].kor+" ");
		}
		System.out.print(":>");
		System.out.println(System.nanoTime() - startTime);
		userChoice = scan.nextInt(); //정답 받고
		startTime = System.nanoTime();
		if (userChoice == -1) break;
		System.out.println(userChoice-1 == resultIdx ? "정답" : "오답");
		
		} while (true);
		
		scan.close();
	}

}
