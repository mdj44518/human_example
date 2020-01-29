package step10.exercise;

import java.util.Arrays;

public class HighStudent extends Student {
	private String[] subjects;
	private int[] scores;
	
	public HighStudent(String name) {
		super(name);
	}
	
	public HighStudent(String name, int numScores) {
		super(name);
		this.name = name;
		scores = new int[numScores];
		//subjects = new String[numScores];
	}
	
	public void setClassNum(int numScores) {
		scores = new int[numScores];
		//subjects = new String[numScores];
	}
	
	public void setSubject(String[] subjects) {
		this.subjects = subjects;
	}
	
	@Override
	public void makeExam() {
		for (int i = 0; i < scores.length; i++) {
			scores[i] = (int)(Math.random() * 101);
		}
	}
	
	@Override
	public double getAvg() {
		double sum = 0.0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		
		return sum / scores.length;
	}
	
	/*
	 *  이름 과목(점수), 과목(점수)
	 */
	@Override
	public void reportScore() {
		for (int i = 0; i < scores.length; i++) {
			if (i == 0) {
				System.out.print(getName() + " " + subjects[i] + "[" + scores[i] + "]");
			} else {
				System.out.print(", " + subjects[i] + "[" + scores[i] + "]");
			}
		}
		System.out.println();
	}
}
