package step04;

public class _01_IfElseDemo {

	public static void main(String[] args) {
		String season = "spring";
		
		if (season.equals("spring")) {
			System.out.println("Flowers will be blossom...");
		} else {
			System.out.println("I don't like it");
		}
		
		int score = 80;
		
		if (score > 90) {
			System.out.println("성적 우수");
		} else {
			System.out.println("성적 보통");
		}
		
		float ratio = 85 * (3 / 2.0f);
		if (ratio > 150) {
			System.out.println("미세먼지 매우 나쁨");
		} else if (ratio > 130) {
			System.out.println("미세먼지 나쁨");
		} else if (ratio > 110) {
			System.out.println("미세먼지 보통");
		} else {
			System.out.println("미세먼지 좋음");
		}
	}

}
