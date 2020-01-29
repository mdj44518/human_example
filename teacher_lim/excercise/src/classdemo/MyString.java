package classdemo;

// object을 생성하기 위한 템플릿
// 사용자 정의 타입
public class MyString {
	// 멤버 변수
	private String str;
	private int len;
	
	// 생성자
	public MyString() {
		str = "dummy";
		len = 5;
	}
	
	public MyString(String str) {
		this.str = str;
		len = str.length();
	}
	
	//멤버메소드
	public char[] getCharArray() {
		return null;
	}
	
	public boolean isEvenLength() {
		return false;
	}
	
	public boolean setString(String str) {
		// database 접근
		// 사용자가 입력한 str이 욕으로 등록된 것이 아니면,
		if (true) {
			this.str = str; 
			return true;
		} else {
			return false;
		}
	}
	
	public int getLength() {
		return len;
	}
}
