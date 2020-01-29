
public class Thread1 extends Thread {
	int a;
	int b;
	
	public Thread1(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void run() {
		System.out.println("실행을위해 대기합니다");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println((a > b) ? "앞에더큼" : "뒤가큼");
	}
	
	
}
