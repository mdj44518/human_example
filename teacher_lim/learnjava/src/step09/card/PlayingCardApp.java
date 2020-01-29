package step09.card;

import java.util.Arrays;
import java.util.Comparator;

public class PlayingCardApp {

	public static void main(String[] args) {
		PlayingCard[] deck = new PlayingCard[5];
		deck[0] = new PlayingCard("spade", 12);
		deck[1] = new PlayingCard("heart", 12);
		deck[2] = new PlayingCard("haha", 0);
		deck[3] = new PlayingCard("heartt", 15);
		deck[4] = new PlayingCard("spade", 5);
		
		System.out.println(Arrays.toString(deck));
		Arrays.sort(deck, new Comparator<PlayingCard>() {

			@Override
			public int compare(PlayingCard o1, PlayingCard o2) {
				if (o1.getFaceNum(o1.getFace()) == o2.getFaceNum(o2.getFace())) {
					return o1.getRank() - o2.getRank();
				} else {
					return o1.getFaceNum(o1.getFace()) - o2.getFaceNum(o2.getFace());
				}
			}
			
		});
		System.out.println(Arrays.toString(deck));
	}

}

// comparator class
// playingcard 비교할수있는 comparator
// suit(face)가 우선, rank
// face (clover < diamond < heart < spade)
class PlayingCardComparator implements Comparator<PlayingCard> {

	@Override
	public int compare(PlayingCard o1, PlayingCard o2) {
		if (o1.getFaceNum(o1.getFace()) == o2.getFaceNum(o2.getFace())) {
			return o1.getRank() - o2.getRank();
		} else {
			return o1.getFaceNum(o1.getFace()) - o2.getFaceNum(o2.getFace());
		}
	}
	
}
