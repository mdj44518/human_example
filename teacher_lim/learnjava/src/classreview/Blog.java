package classreview;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Blog implements Comparable<Blog> {
	private String author;
	private Calendar date;
	private String content;
	private List<String> comments;
	
	private static int createBlogCount = 0; 
	
	
	public Blog(String name) {
		//super();
		author = name;
		date = Calendar.getInstance();
		comments = new ArrayList<> ();
		createBlogCount++;
	}
	
	public static int getBlogCount() {
		return createBlogCount;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void addComment(String comment) {
		comments.add(comment);
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Blog [author=" + author + ", date=" + date + ", content=" + content + ", comments=" + comments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Blog other = (Blog) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	// 내가 
	@Override
	public int compareTo(Blog o) {
		// 내가 날짜로 뒤에 날짜라는 얘기
		if (date.after(o.date)) {
			return 1;
		} else if (date.equals(o)) {
			return 0;
		} else {
			return -1;
		}
	}
	
	
}




