package step10.exercise;

import java.util.Arrays;

public class LowStudent extends Student {

	private static final int NUM_SCORES = 2;
	private String[] subjects;
	private int[] scores;
	
	public LowStudent(String name) {
		super(name);
		
		subjects = new String[NUM_SCORES];
		scores = new int[NUM_SCORES];
	}
	
	public void setSubject(String subject1, String subject2) {
		subjects[0] = subject1;
		subjects[1] = subject2;
	}
	
	@Override
	public void makeExam() {
		for (int i = 0; i < NUM_SCORES; i++) {
			// 0 ~ 100
			scores[i] = (int)(Math.random() * 101);	
		}
	}
	
	@Override
	public double getAvg() {
		int sum = 0;
		for (int i = 0; i < NUM_SCORES; i++) {
			sum += scores[i];
		}
		
		return sum / (double)NUM_SCORES;
	}
	
	/*
	 *  이름 과목(점수), 과목(점수)
	 */
	@Override
	public void reportScore() {
		for (int i = 0; i < NUM_SCORES; i++) {
			if (i == 0) {
				System.out.print(getName() + " " + subjects[i] + "[" + scores[i] + "]");
			} else {
				System.out.println(", " + subjects[i] + "[" + scores[i] + "]");
			}
		}
	}
}
