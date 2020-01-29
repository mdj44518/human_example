package quiz3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cal {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.clear();
		date.set(Calendar.YEAR, 2020);
		date.set(Calendar.MONTH, 12 - 1);
		date.set(Calendar.DATE, 25);
		
		SimpleDateFormat sim = new SimpleDateFormat("약속 날짜는 yyyy년 MM월 dd일");
		
		System.out.println(sim.format(date.getTime()));
	}

}
