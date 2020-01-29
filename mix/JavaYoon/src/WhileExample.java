
class WhileExample {

	public static void main(String[] args) {
		int cut = 0;
		while (cut < 10) {
			System.out.println(cut);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cut++;
		}
		System.out.println("Done.");
		
		new Thread(() -> {
			int cut2 = 0;
			do {
				System.out.println(cut2);
				cut2++;
			} while (cut2 < 10);
			System.out.println("Done.");
		}).start();
		
		for (;;) {
			System.out.println("111");
		}

	}

}
