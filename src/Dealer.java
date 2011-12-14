import java.util.LinkedList;
import java.util.List;


public class Dealer {
	public static void main(String[] args) {
		DeckOfCards cards = new DeckOfCards();
		CribbagePoints count = new CribbagePoints();
		int handSize = 4;
		List<Card> hand = new LinkedList<Card>();
		//Card start = cards.draw();
		Card start;
		
		
		
		start = cards.getCard(5, 1);
		
		hand.add(cards.getCard(5, 3));
		hand.add(cards.getCard(5, 2));
		hand.add(cards.getCard(5, 0));
		hand.add(cards.getCard(11, 1));
		System.out.println(start.getNumber()+" of "+start.getSuit());
		
		
		for(Card c: hand){
			System.out.println(c.getNumber()+" of "+c.getSuit());
		}
		System.out.println(count.checkPoints(hand, start,true)+" Points");
	}

}
