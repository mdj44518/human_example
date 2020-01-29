package level1;

import java.util.Arrays;

public class ExamSimul2 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		ExamSimul2 exam = new ExamSimul2();
		int[] best = exam.solution(a);
		System.out.println(Arrays.toString(best));
	}

	public int[] solution(int[] answers) {
		int[][] stAns = makeExams(answers.length);
//		int[] firstAns = makeExam(1, answers.length);
//		int[] secondAns = makeExam(2, answers.length);
//		int[] thirdAns = makeExam(3, answers.length);
		
		int[] scores = new int[3];
		int[] stScores = checkStAnswers(stAns, answers);
//		scores[0] = checkAnswers(firstAns, answers);
//		scores[1] = checkAnswers(secondAns, answers);
//		scores[2] = checkAnswers(thirdAns, answers);

		int[] best = whoIsBest(scores);
		return best;
	}

	private int[] checkStAnswers(int[][] stAns, int[] answers) {
		int[] scores = new int[stAns.length];
		
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < answers.length; j++) {
				if (stAns[i][j] == answers[j]) {
					scores[i] += 1;
				}
			}
		}
		return scores;
	}

	// scores: 수포자들의 점수
	// 최고점을 획득한 수포자들의 번호를 배열에 담아 리턴
	// ex) [4,4,1]
	private int[] whoIsBest(int[] scores) {
		int max = scores[0];
		int count = 0;
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
				count = 1;
			} else if (max == scores[i]) {
				count++;
			}
		}
		/*
		for (int i = 0; i < scores.length; i++) {
			if (max == scores[i]) {
				count++;
			}
		}
		*/
		int[] best = new int[count];
		int bestIdx = 0;
		for (int i = 0; i < scores.length; i++) {
			if (max == scores[i]) {
				best[bestIdx] = i + 1;
				bestIdx++;
			}
		}
		
		return best;
	}

	// stAnswers: 수포자의 답안
	// answers: 답안
	// 채점하여 점수(정답의 개수) 리턴
	private int checkAnswers(int[] stAnswers, int[] answers) {
		int sum = 0;
		for (int i = 0; i < stAnswers.length; i++) {
			if (stAnswers[i] == answers[i]) {
				sum += 1;	// sum++
			}
		}
		return sum;
	}

	public int[][] makeExams(int length) {
		int[][] patterns = {
				{1, 2, 3, 4, 5},
				{2, 1, 2, 3, 2, 4, 2, 5},
				{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};
		int[][] stAns = new int[3][length];
		
		for (int i = 0; i < stAns.length;i++) {
			int patternIdx = 0;
			for (int j = 0; j < stAns[i].length; j++) {
				stAns[i][j] = patterns[i][patternIdx];
				patternIdx++;
			}
		}
		
		return stAns;
	}
	
	// stNum: 수포자 번호
	// length: 시험문제 개수
	// 수포자들의 패턴에 따라 시험문제 개수만큼의 수포자 답을 배열에
	// 담아 리턴
	private int[] makeExam(int stNum, int length) {
		int[] firstP = {1, 2, 3, 4, 5};
		int[] secondP = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] thirdP = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] answer = new int[length];
		
		int pIdx = 0;
		if (stNum == 1) {
			for (int i = 0; i < answer.length; i++) {
				answer[i] = firstP[pIdx];
				pIdx++;
				if (pIdx == firstP.length) {
					pIdx = 0;
				}
			}
		} else if (stNum == 2) {
			for (int i = 0; i < answer.length; i++) {
				answer[i] = secondP[pIdx];
				pIdx++;
				if (pIdx == secondP.length) {
					pIdx = 0;
				}
			}
		} else if (stNum == 3) {
			for (int i = 0; i < answer.length; i++) {
				answer[i] = thirdP[pIdx];
				pIdx++;
				if (pIdx == thirdP.length) {
					pIdx = 0;
				}
			}
		} else {
			return null;
		}
		
		return answer;
	}

	
}
