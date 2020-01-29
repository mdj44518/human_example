package step06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 12;
		int scoreNum = 4;
		String[] names = new String[number];
		int[][] scores = new int[number][scoreNum];
		double[] avgs = new double[number];
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < names.length; i++) {
			names[i] = scan.next();
			int sum = 0;
			for (int j = 0; j < scores[i].length - 1; j++) {
				scores[i][j] = scan.nextInt();
				sum = sum + scores[i][j];
			}
			
			scores[i][scores[i].length - 1] = sum;
			avgs[i] = (double)sum / (scores[i].length - 1);
		}
		
		// 이름출력
		String header = String.format("%5s:%4s%4s%4s%5s%6s", 
					"이 름", "kuk", "eng", "mat", "sum", "avg");
		System.out.println(header);
		System.out.println("========================");
		for (int i = 0; i < names.length; i++) {
			String output = String.format("%5s:%4d%4d%4d%5d%6.2f", 
					names[i], 
					scores[i][0], scores[i][1], scores[i][2],
					scores[i][3],
					avgs[i]);
			System.out.println(output);
		}
	}

}
