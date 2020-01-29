package step15;

import java.util.HashSet;

public class CollectionSetDemo3 {

	

	public static void main(String[] args) {
		HashSet<Book2> books = new HashSet<> ();
		
		books.add(new Book2(11, "ABC"));
		books.add(new Book2(12, "Lion"));
		books.add(new Book2(13, "Tiger"));

		System.out.println(books);
		
		// 동일한 id/title 책을 다시 추가
		// set 은 어떻게?
		books.add(new Book2(12, "Lion"));
		System.out.println(books);
	}

}

class Book2 {
	int id;
	String title;
	String author;
	int page;
	
	public Book2(int id, String title) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book2 other = (Book2) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
