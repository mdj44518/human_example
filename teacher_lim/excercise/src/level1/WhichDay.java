package level1;

public class WhichDay {

	public static void main(String[] args) {
		WhichDay wDay = new WhichDay();
		String day = wDay.solution(1, 1);	// "TUE"
		System.out.println(day);
	}
	
	// 2016 무슨요일인지?
	// 입력: a(month), b(day)
	// 리턴: 무슨요일("SAT") String
	public String solution(int a, int b) {
		// 입력된 날짜까지의 일의 합
		int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int totalDayNum = 0;
		// 주어진 입력의 전달까지 날짜의 합
		for (int i = 0; i < a - 1; i++) {
			totalDayNum += monthDays[i];
		}
		totalDayNum += b;
		
		String day = null;
		int dayRemainder = totalDayNum % 7;
		switch (dayRemainder) {
		case 0:
			day = "THU";
			break;
		case 1:
			day = "FRI";
			break;
		case 2:
			break;
		case 3:
			day = "SUN";
			break;
		case 4:
			day = "MON";
			break;
		case 5:
			day = "TUE";
			break;
		case 6:
			day = "WED";
			break;
		}
		
		return day;
	}

}
