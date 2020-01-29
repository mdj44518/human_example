package step11;

public class EnumDemo1 {

	private static final int WINTER = 1;
	private static final int SPRING = 2;
	private static final int SUMMER = 3;
	private static final int FALL = 4;
	
	public static void main(String[] args) {
		
		String sport = seasonSport(FALL);
		
		System.out.println(sport);

		// 다음의 의미?
		sport = seasonSport(10);
	}

	public static String seasonSport(int season) {
		switch (season) {
		case WINTER:
			return "스키";
		case SPRING:
			return "사이클링";
		case SUMMER:
			return "수영";
		case FALL:
			return "마라톤";
		default:
			return "조깅";
		}
	}
}


