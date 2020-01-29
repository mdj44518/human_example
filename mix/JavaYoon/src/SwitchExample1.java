
class SwitchExample1 {
	
	public static void main(String[] args) {
		new Thread(() -> {
			int num = 3;
			switch (num) {
			case 1 :
				System.out.println("Good Morning Java");
				break;
			case 2 :
				System.out.println("Good Afternoon Java");
				break;
			case 3 :
				System.out.println("Good Evening Java");
				break;
			default :
				System.out.println("Hellow Java");
				break;
			}
		}).start();
	}
}
