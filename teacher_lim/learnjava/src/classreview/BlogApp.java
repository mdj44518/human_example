package classreview;

import java.io.File;

public class BlogApp {

	public static void main(String[] args) {
		//Blog b = new Blog("dla");
		Blog[] blogs = new Blog[5];
		blogs[0] = new ImageBlog("호호");
		blogs[1] = new MobileBlog("하하");
		blogs.clone();
		Blog b1 = new MobileBlog("홍길동");
		MobileBlog b2 = new MobileBlog("박잘해");
		ImageBlog b3 = new ImageBlog("이자바");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageBlog b4 = new ImageBlog("이자바");
		
		b1.setContent("난 잘해");
		b1.addComment("넌 못해");
		
		b2.setContent("봄이왔구나");
		
		File f = new File("flower.jpg");
		b3.setImageFile(f);
		
		if (b3.equals(b4)) {
			System.out.println("두블로그가 같은 거빈다");
		}
		
		displayContent(b1);
		displayContent(b4);
		System.out.println(Blog.getBlogCount());
		
		Publishable p = new HtmlPublisher();
		b4.setContent(p);
	}
	
	public static void displayContent(Blog b) {
		System.out.println(b.getContent());
	}

}
