package step14;

public class InterfaceDemo2 {

	public static void main(String[] args) {
	
		Message m = new Message("Java");
		m.reverse();
		System.out.println(m.getMessage());
		
		MyNumber num = new MyNumber(1234);
		num.reverse();
		System.out.println(num.getValue());
	}

}

interface Reversable {
	void reverse();
}

class Message implements Printable, Reversable{

	private String message;
	
	public Message(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public void print() {
		System.out.println("my message: " + message);
	}

	@Override
	public void reverse() {
		StringBuffer sb = new StringBuffer();
		for (int i = message.length() - 1; i >= 0; i--) {
			sb.append(message.charAt(i));
		}
		
		message = sb.toString();
	}
	
}

class MyNumber implements Printable, Reversable {

	private int value;
	
	public MyNumber(int a) {
		value = a;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public void print() {
		System.out.println("my message: " + value);
	}

	@Override
	public void reverse() {
		StringBuffer sb = new StringBuffer();
		String strValue = String.valueOf(value);
		for (int i = strValue.length() - 1; i >= 0; i--) {
			sb.append(strValue.charAt(i));
		}
		
		value = Integer.parseInt(sb.toString());
	}
	
}
