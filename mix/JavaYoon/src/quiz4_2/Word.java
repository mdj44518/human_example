package quiz4_2;

import java.util.HashMap;
import java.util.Map;

public class Word {
	String eng;
	String kor;
	Word(String eng, String kor){
		this.eng = eng;
		this.kor = kor;
	}
	
	public static void main(String[] args) {
		WordQuiz2 quiz = new WordQuiz2();
		System.out.println("시작?");
		quiz.main(null);
	}

	public String getEnglish() {
		// TODO Auto-generated method stub
		return eng;
	}

	public String getKorean() {
		// TODO Auto-generated method stub
		return kor;
	}
}
