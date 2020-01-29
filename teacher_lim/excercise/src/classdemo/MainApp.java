package classdemo;

public class MainApp {

	public static void main(String[] args) {
		int value = 10;
		MyString myS = new MyString(); 
		MyString yourS = new MyString("ABC");

		char[] arr = myS.getCharArray();
		if (myS.isEvenLength()) {
			myS.setString("zerky");
		} else {
			System.out.println(myS.getLength());
		}
	}

}
