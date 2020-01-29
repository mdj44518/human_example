package step05;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class _11_LocalDateTimeDemo {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalDate theDate = LocalDate.of(2019, 3, 15);
		theDate = LocalDate.parse("2015-02-15");
		System.out.println(theDate);
		
		LocalDate preMonth = theDate.minus(1, ChronoUnit.MONTHS);
		System.out.println(preMonth);
		DayOfWeek week = preMonth.getDayOfWeek();
		System.out.println(week);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(localTime.format(dtf));
		
		LocalTime theTime = LocalTime.parse("07:30:10");
		System.out.println(theTime);
		
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localdt = LocalDateTime.now();
		System.out.println(localdt.format(dtf));
		LocalDateTime thedt = LocalDateTime.of(2015, 2, 15, 13, 30, 30);
		System.out.println(thedt.format(dtf));
		
		thedt = thedt.plus(1, ChronoUnit.MONTHS);
		System.out.println(thedt.format(dtf));
	}

}
