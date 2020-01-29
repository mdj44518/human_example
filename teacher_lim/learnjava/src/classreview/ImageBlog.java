package classreview;

import java.io.File;

// 
public class ImageBlog extends Blog {
	private File imageFile;
	
	public ImageBlog(String name) {
		super(name);
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}
	
	@Override
	public void setContent(String content) {
		if (imageFile != null) {
			String str = content + " [" + imageFile.getPath() + "]";
			super.setContent(str);
		} else {
			super.setContent(content);
		}
		
	}
	
	public void setContent(Publishable p) {
		setContent(p.getContent());
	}
	
}
