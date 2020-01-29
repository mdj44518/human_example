package step09.class3;

import java.util.Random;

/*
 * 속성
 * 책제목
 * ISBN 코드
 * 저자
 * 페이지수
 * 
 * 기능
 *  displayInfo()
 *  String toString() 
 *    "title(저자), pageNum"
 *    
 * 가져가는 메소드(getters)
 * 셋하는 메소드(setters)
 */
public class Book {
	private String title;
	private String isbn;
	private String author;
	private int pageNum;
	
	// 생성자 (constructors)
	public Book(String title) {
		if (setTitle(title) == false) {
			this.title = "untitled";
		}
		setISBN();
	}
	
	// 책제목은 최소 2자이상
	// 숫자로 시작하면 안되고,
	// 영어로 시작해도 안되고,....
	public boolean setTitle(String name) {
		if (name.length() < 2) {
			System.out.println("Error: 책제목은 2자 이상입니다");
			return false;
		}
		title = name;
		return true;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getTitle() {
		return title;
	}
	
	public String getISBN() {
		return isbn;
	}
	
	private void setISBN() {
		// ISBN 조직에서 부터 ISBN넘버를 구해하여
		// 해당 책에 코드를 저장
		Random r = new Random();
		isbn = String.valueOf(r.nextInt());
	}
	
	public void displayInfo() {
		System.out.println("Title: " + title);
		System.out.println("ISBN: " + isbn);
		System.out.println("Auther: " + author);
		System.out.println("Page: " + pageNum);
	}
	
	// annotation (부연설명)
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pageNum=" + pageNum + "]";
	}
}










