package step15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionDemo4 {

	public static void main(String[] args) {
		List<Book3> list = new ArrayList<> ();

		list.add(new Book3(5, "하늘"));
		list.add(new Book3(2, "바람"));
		list.add(new Book3(10, "강"));
		list.add(new Book3(1, "꽃"));
		
		for (Book3 b : list) {
			System.out.println(b);
		}
		
		Collections.sort(list);
		System.out.println("정렬 후");
		for (Book3 b : list) {
			System.out.println(b);
		}
		
		Comparator<Book3> bookTitleComparator = new BookTitleComparator();
		Collections.sort(list, bookTitleComparator);
		System.out.println("책 제목으로 정렬후");
		for (Book3 b : list) {
			System.out.println(b);
		}
	}

}

class Book3 implements Comparable<Book3>{
	int id;
	String title;
	String author;
	int page;
	
	public Book3(int id, String title) {
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

	@Override
	public int compareTo(Book3 o) {
		int diff = this.id - o.id;
		
		return diff;
	}
	
}

class BookTitleComparator implements Comparator<Book3> {

	@Override
	public int compare(Book3 o1, Book3 o2) {
		return o1.title.compareTo(o2.title);
	}
	
}