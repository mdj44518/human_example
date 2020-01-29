package step15;

import java.util.HashSet;

public class CollectionSetDemo2 {

	public static void main(String[] args) {
		HashSet<Book> books = new HashSet<> ();
		
		books.add(new Book(11, "ABC"));
		books.add(new Book(12, "Lion"));
		books.add(new Book(13, "Tiger"));

		//System.out.println(books);
		for (Book b : books) {
			System.out.println(b);
		}
		
		// 동일한 id/title 책을 다시 추가
		// set 은 어떻게?
		books.add(new Book(12, "Lion"));
		//System.out.println(books);
		for (Book b : books) {
			System.out.println(b);
		}
	}

}

class Book {
	int id;
	String title;
	String author;
	int page;
	
	public Book(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", page=" + page + "]";
	}
	
	
}
