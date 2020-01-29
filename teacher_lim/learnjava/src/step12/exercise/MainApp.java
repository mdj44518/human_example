package step12.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Account class
 *  - 속성:
 *    . 계좌이름
 *    . 계좌소유자의 이름
 *    . 계좌번호
 *    . 금액
 *  - 기능:
 *    . double getTotal();
 *    . void deposit(double money);
 *    . double withdraw(double money);
 *    
 * DepositAccount class(자유예금)
 *  - 속성:
 *    . fee(년)
 *    
 * SavingAccount class (적금/예금)
 *  - 속성:
 *    . 종류 예금통장 종류(Enum) - 적금, 예금, 예적금
 *    . 월 이율
 *     
 * 
 */
public class MainApp {

	public static void main(String[] args) {

		File inputFile = new File("account.txt");
		Account[] accounts = new Account[5];
		int cnt = 0;
		
		//Account acc = new Account();
		try {
			Scanner scan = new Scanner(inputFile);
			while (scan.hasNextLine()) {
				String input = scan.nextLine();
				String[] tokens = input.split("/");
				if (input.length() == 0) break;
				//System.out.println(Arrays.toString(tokens));
				
				// String[](정보) --> Account객체
				if (cnt >= 5) {
					break;
				}
				
				accounts[cnt] = getAcctObj(tokens);
				cnt++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(accounts));
		
		accounts[2].save(15.0);
		accounts[3].withdraw(5.5);
		
		System.out.println(Arrays.toString(accounts));
	}
	
	public static Account getAcctObj(String[] infos) {
		if (infos == null) {
			return null;
		}
		
		if (infos.length != 6 && infos.length != 7) {
			return null;
		}
		
		Account result = null;
		if (infos[4].equalsIgnoreCase("deposit")) {
			result = new DepositAccount(infos[0], infos[1], infos[2]);
			try {
				result.setAmount(Double.parseDouble(infos[3]));
				((DepositAccount)result).setFee(Double.parseDouble(infos[5]));
			} catch (Exception e) {
				System.out.println("ERROR: Account info set was failed");
			}
		} else if (infos[4].equalsIgnoreCase("saving")) {
			result = new SavingAccount(infos[0], infos[1], infos[2]);
			try {
				result.setAmount(Double.parseDouble(infos[3]));
				int numType = Integer.parseInt(infos[5]);
				if (numType == 0) {
					((SavingAccount)result).setsType(SavingAcctType.YGSAVING);
				} else if (numType == 1) {
					((SavingAccount)result).setsType(SavingAcctType.GGSAVING);
				} else {
					((SavingAccount)result).setsType(SavingAcctType.YGGSAVING);
				}
				((SavingAccount)result).setRate(Double.parseDouble(infos[6]));
			} catch (Exception e) {
				System.out.println("ERROR: Account info set was failed");
			}
		} else {
			return null;
		}
		
		return result;
	}

}
