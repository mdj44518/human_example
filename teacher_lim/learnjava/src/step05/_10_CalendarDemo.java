package step05;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class _10_CalendarDemo {

	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar(2015, 1, 15, 12, 30, 30);
		System.out.println(cal.getTime());
		System.out.println(cal.getTimeZone().getID());
		
		cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
	}

}
