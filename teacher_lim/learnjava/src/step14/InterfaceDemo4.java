package step14;

public class InterfaceDemo4 {

	public static void main(String[] args) {
		MyContainer m = new MyContainer("홍길동", 30);
		
		MyContainer m_copy = m.copy();
		
		m.setMessage("김돌쇠");
		
		System.out.println(m);
		System.out.println(m_copy);

	}

}

interface Copyable<T> {
	int maxCopy = 5;

	public static int getMaxCopy() {
		return maxCopy;
	}

	public default void copyright() {
		System.out.println("저작권에 주의하세요");
	}

	public T copy();
}

class MyContainer implements Copyable<MyContainer> {

	private String message;
	private int value;

	public MyContainer(String m, int v) {
		this.message = m;
		this.value = v;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyContainer [message=" + message + ", value=" + value + "]";
	}

	@Override
	public MyContainer copy() {
		MyContainer c = new MyContainer(this.message, this.value);

		System.out.println(Copyable.getMaxCopy() + " copy is allowed");
		this.copyright();
		return c;
	}

}
