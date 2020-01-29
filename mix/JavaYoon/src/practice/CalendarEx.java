package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		printCalendar("현재", now);
		
		System.out.println(now.get(Calendar.AM_PM));
		System.out.println(Calendar.PM);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd E요일");
		
		System.out.println(sim.format(now.getTime()));
		
		System.out.println((int)'C');
	}

	static void printCalendar(String msg, Calendar cal) {
	}

}
