
public class MethodExample1 {
	public static void main(String[] args) {
		Account obj1 = new Account("111-222-333","김영식", 20000);
		Account obj2 = new Account("555-666-777","박진희", 100000);
		obj1.deposit(100000);
		obj2.withdraw(20000);
		printAccount(obj1);
		printAccount(obj2);
	}
	static void printAccount(Account obj) {
		System.out.println("계좌번호:" + obj.accountNo);
		System.out.println("성명:" + obj.ownerName);
		System.out.println("잔액:" + obj.balance);
		System.out.println();
		
	}
}
