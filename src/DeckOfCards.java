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
		 * ranging from  Ace to King.
		 */
		final int cardValues = 13;
		for(int i=1;i<=cardValues;i++){
			for(Card.Suit suit: Card.Suit.values()){
				deckSave.add(new Card(i, suit));
			}
		}
		
		deck = new LinkedList<Card>(deckSave);
		
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
		 * ACE = 1
		 * ...
		 * KING = 13
		 * 
		 * 0 = HEARTS
		 * 1 = SPADES
		 * 2 = DIAMONDS
		 * 3 = CLUBS
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
		
		int i = randInt.nextInt(deck.size());
		Card drawn = deck.get(i);
		deck.remove(i);
		return drawn;
	}
	
}

final class Card{
	public enum Suit{HEARTS,SPADES,DIAMONDS,CLUBS}
	
	private final Suit suit;
	private final int value;
	
	Card(int v, Suit s){
		this.value = v;
		this.suit = s;
	}
	
	public String toString(){return value+" of "+suit;}
	
	public Suit getSuit() {return suit;}
	
	public int getNumber() {return value;}
	
}	
