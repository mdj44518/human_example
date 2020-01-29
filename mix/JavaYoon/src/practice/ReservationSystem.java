package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReservationSystem {
	
	static String[][] seats = new String[3][11];
	static Thread t1;

	public static void main(String[] args) {
		t1 = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			seats = Arrays.stream(seats).map(x -> 
//				x = Arrays.stream(x).map(y -> y = "--- ")
//				.collect(Collectors.toList()).toArray(new String[0]))
//			.collect(Collectors.toList()).toArray(new String[0][]);
			
			char[] list = {'S','A','B'};
			
			
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					seats[i][j] = (j == 0) ? list[i]+">> " : "--- ";
				}
			}
			
		});
		t1.start();
		Scanner scan = new Scanner(System.in);
		String choice = "";
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		while (!choice.equals("4")) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			choice = scan.nextLine();
			switch (choice) {
			case "1":
				addReservation(); break;
			case "2":
				readReservation(); break;
			case "3":
				removeReservation(); break;
			case "4": break;
			default :
				System.err.println("잘못된 명령어 입니다.");
			}
		}

	}

	private static void addReservation() {
		// TODO Auto-generated method stub
		
		
	}

	private static void readReservation() {
		// TODO Auto-generated method stub
		
//		String[] list = {"S","A","B"};
//		IntStream.range(0, 3).forEach(x -> {
//			System.out.print(list[x] +">> ");
//			Arrays.stream(seats[x]).forEach(System.out::print);
//			System.out.println();
//		});
//		Arrays.stream(seats).forEach(x -> {
//				Arrays.stream(x)
//				.forEach(System.out::print);
//				System.out.println();
//				});
		
//		Arrays.stream(seats).forEach(x -> {
//			Arrays.stream(x).forEach(System.out::print);
//			System.out.println();
//			});
		// 제일 좋은코드 = 주석도 필요없는코드
		// 주석 잘달린코드
		// 주석 폭탄..
//		Thread t2 = new Thread(()->{ // 아직 초기화 중입니다... ? 를 어찌하지
//			
//		});
//		t2.start();
		if (!t1.getState().name().equals("TERMINATED")) System.out.print("초기화 대기중 입니다");
		while (!t1.getState().name().equals("TERMINATED")) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		for (String[] sArr : seats) {
			for (String s : sArr) {
				System.out.print(s); 
			}
			System.out.println();
		}
		
//		for (String[] s : seats) {
//			Arrays.stream(s).forEach(System.out::print);
//			System.out.println();
//		}
		
	}

	private static void removeReservation() {
		// TODO Auto-generated method stub
		
	}

}
