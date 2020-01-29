package step11;

public class EnumDemo2 {

	public enum Season {
		WINTER,
		SPRING,
		SUMMER,
		FALL
	}
	
	public static void main(String[] args) {
		
		String sport = seasonSport(Season.FALL);
		
		System.out.println(sport);

		// sport = seasonSport(10); 컴파일 에러
		
		// 모든 season 값 출력
		for (Season s : Season.values()) {
			System.out.println(s);
		}

	}

	public static String seasonSport(Season season) {
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


