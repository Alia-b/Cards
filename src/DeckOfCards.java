import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class DeckOfCards {
	private List<Card> deck = new LinkedList<Card>();
	private List<Card> deckSave = new LinkedList<Card>();
	private Random randInt =  new Random();
	
	public DeckOfCards(){
		/*
		 * Creates a deck of cards of each of four possible suits,
		 * ranging from one to thirteen. One being an Ace and 
		 * thirteen a King.
		 */
		int suits = 4;
		int cardNums = 13;
		for(int i=1; i<=cardNums ; i++){
			for(int j=0;j < suits;j++){
				deckSave.add(new Card(i,j));
			}
		}
		deck = new LinkedList<Card>(deckSave);
		
		System.out.println(deckSave.size());
	}
	public void shuffle(){
		/*
		 * Returns the deck to it's original state.
		 * 
		 * If you have drawn any Cards and stored them
		 * they should be destroyed or you will have duplicates.
		 */
		deck.clear();
		deck = new LinkedList<Card>(deckSave);
		
	}
	public Card getCard(int num, int suit){
		/*
		 * Removes and returns the specified card from the deck.
		 * 
		 * 0 = CLUBS
		 * 1 = DIAMONDS
		 * 2 = HEARTS
		 * 3 = SPADES
		 */
		
		//Magic
		int i = ((num-1)*4)+suit;
		Card c = deckSave.get(i);
		Card d = deck.get(deck.indexOf(c));
		deck.remove(c);
		return d;
	}
	
	public Card draw(){
		/*
		 * Removes and returns one random Card object from the deck.
		 */
		Card drawn;
		int j = randInt.nextInt(deck.size());
		drawn = deck.get(j);
		deck.remove(j);
		return drawn;
	}
	
}

final class Card{
	private final int number;
	private static enum suits{HEARTS,SPADES,DIAMONDS,CLUBS}
	private final suits suit;
	
	Card(int number,int whichSuit){
		switch (whichSuit) {
		case 0:
			this.suit =suits.CLUBS;
			break;
		case 1:
			this.suit =suits.DIAMONDS;
			break;
		case 2:
			this.suit =suits.HEARTS;
			break;
		case 3:
			this.suit =suits.SPADES;
			break;
		default:
			this.suit =suits.CLUBS;
			throw new IllegalArgumentException("Illegal argument for whichSuit. Defaulted to CLUBS");
		}
		this.number = number;
	}
	public suits getSuit() {
		return suit;
	}
	public int getNumber() {
		return number;
	}
	
}	
