package step05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _09_UtilDateDemo {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		// 현재시간
		System.out.println(date);

		// 특정시간
		//Date theDate = new Date(2019, 2, 15); deprecated
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date theDate = dateFormat.parse("2019/2/15 0:0:0");
		System.out.println(theDate);
		System.out.println(dateFormat.format(theDate));
		
		if (date.before(theDate)) {
			System.out.println("오늘은 그날 전입니다.");
		} else {
			System.out.println("오늘은 그날 후입니다");
		}
	}

}
