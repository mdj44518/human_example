package step09.card;

/*
 * 속성:
 *  face (heart, spade, clover, diamond)
 *  rank (1(ace), 2, ... , 10, j, q, k)
 *  color
 *  
 * 기능:
 *  // 같음비교
 *  boolean equals(PlayingCard p)
 *  // 대소관계
 *  // rank의 크기에따라 대소가 정해지는데, (2 < 3 < 4 < .... < j < q < k < ace < joker) 
 *  // 만약 rank가 같다면, clover < diamond < heart < spade
 *  // 내가 크면, 양수
 *  // 내가 작으면, 음수
 *  // 같으면, 0을 리턴
 *  int compareTo(PlayingCard p)
 */
public class PlayingCard implements Comparable<PlayingCard> {
	// 속성
	private String face;
	private int rank;
	private String color;
	
	// 생성자
	// joker 
	// rank
	// noCard
	public PlayingCard(String face, int rank) {
		if (rank == 0) {
			this.face = "joker";
			this.rank = 0;
			
			return;
		}
		
		if (face.equalsIgnoreCase("spade") ||
				face.equalsIgnoreCase("heart") ||
				face.equalsIgnoreCase("diamond") ||
				face.equalsIgnoreCase("clover")) {
			this.face = face;
		} else {
			this.face = "noCard";
			this.rank = -1;
			return;
		}
		
		if (rank > 0 && rank <= 13) {
			this.rank = rank;
		} else {
			this.face = "noCard";
			this.rank = -1;
		}
	}
	
	// getters / setters
	
	// equals
	// face와 rank가 같으면 같은카드
	public boolean equals(PlayingCard p) {
		if (face.equals(p.getFace()) && rank == p.getRank()) {
			return true;
		} else {
			return false;
		}
	}
	
	// compareTo
	// rank (2 < 3 < ... < j < q < K < ace)
	// face (clover < diamond < heart < spade)
	public int compareTo(PlayingCard p) {
		int rankDiff = rank - p.getRank();
		
		if (rankDiff == 0) {
			int faceDiff = getFaceNum(face) - getFaceNum(p.getFace());
			return faceDiff;
		} else {
			return rankDiff;
		}
	}
	
	public int getFaceNum(String face) {
		switch (face) {
		case "spade":
			return 4;
		case "heart":
			return 3;
		case "diamond":
			return 2;
		case "clover":
			return 1;
		default:
			return 0;
		}
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFace() {
		return face;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		String faceCode = null;
		if (face.equals("spade")) {
			faceCode = "\u2660";
		} else if (face.equals("heart")) {
			faceCode = "\u2665";
		} else if (face.equals("diamond")) {
			faceCode = "\u2662";
		} else if (face.equals("clover")) {
			faceCode = "\u2663";
		} else if (face.equals("joker")) {
			return "PlayingCard [JOKER]";
		} else {
			return "NO PlayingCard [XXX]";
		}
		
		return "PlayingCard [" + faceCode + rank + "]";
	}

	public boolean isValid() {
		if (face.equals("noCard") || rank == -1) {
			return false;
		} else {
			return true;
		}
	}
}












