package step07;

public class _05_VariableScopeDemo2 {

	// 멤버변수
	int mNum;
	String mName;
	
	// static 변수
	static int sNum;
	static String sName;
	
	public static void main(String[] args) {
		// 접근 테스트
		// mNum = 10; compile error
		// mName = new String();
		_05_VariableScopeDemo2 var = new _05_VariableScopeDemo2();
		var.mNum = 20;
		var.mName = "hello";
		var.func2();
		sNum = 10;
		sName = new String("Cool~");
		
		func1();
		//func2();	compile error
		/*
		_05_VariableScopeDemo2 obj = new _05_VariableScopeDemo2();
		obj.func2();
		*/
	}

	// static function
	public static void func1() {
		System.out.println("sNum = " + sNum);
		System.out.println("sName = " + sName);
	}
	
	// non-static function
	public void func2() {
		mNum = 123;
		mName = "재갈공명";
		
		System.out.println(mNum + ", " + mName);
	}
}
