package level1;

import java.util.Arrays;

public class ExamSimul {

	public static void main(String[] args) {
		int[] a = {1,3,2,4,2};
		ExamSimul exam = new ExamSimul();
		int[] best = exam.solution(a);
		System.out.println(Arrays.toString(best));
	}

	public int[] solution(int[] answers) {		
		int[] scores = new int[3];
		
		int[][] stAnswers = new int[3][];
		stAnswers = makeExam(answers.length);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < answers.length; j++) {
				if (stAnswers[i][j] == answers[j]) {
					scores[i]++;
				}
			}
		}
		
		// 최고 값 찾기
		int[] best = whoIsBest(scores);
		return best;
	}

	// 주어진 수포자들어 점수배열에서 최고점을 받은 사람들의 번호를
	// 배열에 담아 리턴
	private int[] whoIsBest(int[] scores) {
		int count = 0;
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
			} else if (max == scores[i]) {
				count++;
			}
		}

		int k = 0;
		int[] result = new int[count];
		for (int i = 0; i < scores.length; i++) {
			if (max == scores[i]) {
				result[k] = i + 1;
				k++;
			}
		}
		
		return result;
	}

	// 주어진 시험의 문제 개수에 따라 수포자들의 답안지를 생성하여 리턴
	// 예: 길이 = 5
	/*
	 * 주어진 시험의 문제 개수에 따라 수포자들의 답안지를 생성하여 리턴
	 * 예: 길이 = 5
	 * {
	 * 		{1,2,3,4,5},
	 * 		{2, 1, 2, 3, 2},
	 * 		{3, 3, 1, 1, 2}
	 * }
	 */
	private int[][] makeExam(int length) {
		int[][] patterns = {
				{1, 2, 3, 4, 5},
				{2, 1, 2, 3, 2, 4, 2, 5},
				{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};
		
		int[][] answers = new int[3][length];
		for (int i = 0; i < answers.length; i++) {
			int j = 0;
			for (int k = 0; k < answers[i].length; k++) {
				answers[i][k] = patterns[i][j];
				j++;
				if (j >= patterns[i].length) {
					j = 0;
				}
			}
		} 
		
		return answers;
	}
	
	
}
