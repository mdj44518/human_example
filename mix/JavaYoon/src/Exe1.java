
class Exe1 extends Thread {
	
	

	@Override
	public String toString() {
		return "나는 스포츠맨이다~~~~~";
	}

	@Override
	public void run() {
		int num1 = 52;
		int num2 = 24;
		
		Thread1 t = new Thread1(num1, num2);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if (num1 > num2) {
//			System.out.println("num1 값이 더 큽니다.");
//			System.out.println("num1 : " + num1);
//		}
		System.out.println("Done.");
	}
	
	
}
