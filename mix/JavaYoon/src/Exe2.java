
class Exe2 {

	public static void main(String[] args) {
		
		Exe1 t1 = new Exe1();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num1 = 12;
		int num2 = 24;
		if (num1>num2)
			System.out.println("num1="+num1);
		else
			System.out.println("num2="+num2);
		
		System.out.println("Done.");
		
	}

}
