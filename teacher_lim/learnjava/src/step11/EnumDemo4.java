package step11;

import java.util.Scanner;

public class EnumDemo4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("어떤 카지노게임을 원하십니까");
		String str;
		do {
			System.out.print("--> ");
			str = scan.next();
			str = str.toUpperCase();
			if (str.equals("POKER") || str.equals("FOURCARD") ||
					str.equals("BLACKJACK") || str.equals("SLOTMACHINE")) {
				break;
			} else {
				System.out.println("그런 게임은 없습니다. 다시 입력");
			}
		} while (true);
		
		
		CasinoGame g = CasinoGame.valueOf(str.toUpperCase());
		System.out.println("Fee: " + getEntranceFee(g));
	}

	// 카지노의 게임의 종류에 따라 입장료를 리턴
	public static double getEntranceFee(CasinoGame g) {
		double fee = 0.0;
		switch (g) {
		case POKER:
			fee = 10.0;
			break;
		case FOURCARD:
			fee = 15.0;
			break;
		case BLACKJACK:
			fee = 8.0;
			break;
		case SLOTMACHINE:
			fee = 1.0;
			break;
		default:
			break;
		}
		return fee;
	}
}
