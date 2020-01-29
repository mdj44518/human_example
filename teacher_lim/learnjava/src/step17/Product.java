package step17;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Product implements Serializable {
	
	private String name;
	private String serial;
	private double price;
	private Calendar manDate;
	private List<Integer> reviews;	// 10점 만점
	
	public Product(String name) {
		this.name = name;
		reviews = new ArrayList<> ();
	}
	
	public void addReview(int review) {
		reviews.add(review);
	}
	
	public int[] getReviews() {
		Integer[] arr = reviews.toArray(new Integer[0]);
		int[] result = new int[arr.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Calendar getManDate() {
		return manDate;
	}
	
	// overloading
	public String getMandateString() {
		String result = "";
		result += manDate.get(Calendar.YEAR) + "-";
		result += manDate.get(Calendar.MONTH) + 1 + "-";
		result += manDate.get(Calendar.DATE);
		return result;
	}

	public void setManDate(Calendar manDate) {
		this.manDate = manDate;
	}
	
	// format
	// 1999-02-15
	public void setManDate(String str) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			cal.setTime(format.parse(str));
			this.manDate = cal;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", serial=" + serial + ", price=" 
				+ price + ", manDate=" + manDate.getTime()
				+ ", reviews=" + reviews + "]";
	}
	
}
