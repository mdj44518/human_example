package classreview;

public class MobileBlog extends Blog {

	public MobileBlog(String name) {
		super(name);
	}
	
	@Override
	public void setContent(String content) {
		super.setContent("Mobile " + content);
	}
}
