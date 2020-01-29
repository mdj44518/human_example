package step09.exercise;

import java.util.Arrays;

public class Dice {
	// 속성
	private int numOfSurface;
	private int numOfDices;

	public Dice(int numOfDices) {
		this.numOfDices = numOfDices;
		numOfSurface = 6;
	}

	public int getNumOfSurface() {
		return numOfSurface;
	}

	public void setNumOfSurface(int numOfSurface) {
		this.numOfSurface = numOfSurface;
	}

	public int getNumOfDices() {
		return numOfDices;
	}

	// 기능
	public int[] roll() {
		int[] result = new int[numOfDices];
		for (int i = 0; i < numOfDices; i++) {
			result[i] = (int)(Math.random() * numOfSurface) + 1;
		}
		
		return result;
	}

	public static void main(String[] args) {
		Dice d = new Dice(3);
		d.setNumOfSurface(11);
		int[] values = d.roll();
		System.out.println(Arrays.toString(values));
	}
}
