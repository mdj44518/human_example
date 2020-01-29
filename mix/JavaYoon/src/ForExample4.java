import java.util.stream.IntStream;

class ForExample4 {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};
//		for (int cut = 0; cut < arr.length; cut++) {
//			System.out.println(arr[cut]);
//		}
		for (int num : arr) System.out.println(num);
//		IntStream.of(arr).forEach(System.out::println);
		System.out.println("Done.");
		
		
		//break 예제
		for (int cut = 0; cut < 10; cut++) {
			System.out.println(cut);
			if (cut == 5)
				break;
		}
		System.out.println("Done.");
		
		//continue 예제
		for (int cut = 0; cut < 10; cut++) {
			if (cut == 5)
				continue;
			System.out.println(cut);
		}
		System.out.println("Done.");
		
		Thread t1 = new MyThread();
		t1.start();
		Thread t2 = new Thread(new MyThread2());
		t2.start();
	}
	
	

}

class MyThread2 implements Runnable {
	@Override
		public synchronized void run() {
			System.out.println("쓰레드2 다");
		}
}


class MyThread extends Thread {

	@Override
	public synchronized void run() {
		System.out.println("쓰레드다");
	}
	
}