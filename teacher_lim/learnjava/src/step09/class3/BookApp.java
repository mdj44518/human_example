package step09.class3;

public class BookApp {

	public static void main(String[] args) {
		Book b = new Book("신과함께");
		b.setAuthor("홍길동");
		b.setPageNum(544);
		
		System.out.println(b);
	}

}
