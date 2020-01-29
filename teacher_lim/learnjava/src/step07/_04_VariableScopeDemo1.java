package step07;

public class _04_VariableScopeDemo1 {

	public static void main(String[] args) {
		int var = 5;
		simpleFunc(var);
		int insideVar;
		do {
			insideVar = var;
			insideVar /= 3;	// insideVar = insideVar / 3;
			var++;
		} while (var < 10);
		
		System.out.println("InsideVar = " + insideVar); 
		//   insiderVar 변수는 do { } 블록 내부 변수
		
	}
	
	public static void simpleFunc(int number) {
		int var = 0;
		System.out.println("simpleFunc(): var = " + var);
		
	}

}
