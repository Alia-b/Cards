import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static ch.lambdaj.Lambda.*;


public class CribbagePoints {
	
	public int checkPoints(List<Card> hand, Card startCard, boolean crib){
		int points = 0;
		//Check for nob.
		for(Card i: hand){
			if(i.getNumber() == 11 && i.getSuit() == startCard.getSuit()){
				points += 1;
			}
		}
		
		points += flush(hand, startCard, crib);
		
		hand.add(startCard);
		
		points += pairs(hand);
		
		points += fifteens(hand);
		
		
		return points;
	}
	
	private int pairs(List<Card> pairHand){
		int points = 0;
		int cardsOfNum = 0;
		Card testCard;
		List<Card> tempHand = new LinkedList<Card>(pairHand);
		List<Card> matches = new LinkedList<Card>();
		
		while(!(tempHand.isEmpty())){
			testCard = tempHand.get(0);
			tempHand.remove(0);
			
			
			for(Card card1: tempHand){

				if(card1.getNumber() == testCard.getNumber() && !(matches.contains(card1))){
				
					matches.add(card1);
					
					if(cardsOfNum == 0){
						
						cardsOfNum += 2;
					} else {
						cardsOfNum++;
					}
					
				}
			}
			switch (cardsOfNum) {
			case 2:
				points += 2;
				break;
			case 3:
				points += 6;
				break;
			case 4:
				points += 12;
				break;
			default:
				break;
			}
			
			//Cleanup, reset.
			cardsOfNum = 0;
			if(!(matches.isEmpty())){
				for(Card i: matches){
					tempHand.remove(i);
				}
			}
			matches.clear();
		}
		return points;
	}
	
	private int fifteens(List<Card> fifteenHand){
		int points = 0;
		int n = fifteenHand.size();
		
	    for ( int i = 0; i < 32; i++ ) {
	    	int total = 0;
	    	for( int p = 0; p < n; p++ ) {
	    			if ( ((1 << p) & i) != 0 ) {
	    				int tempVal = fifteenHand.get(p).getNumber();
	    				
	    				total += tempVal<=10 ? tempVal : 10;
	    			}
	    	}
	    	points += total == 15 ? 2 : 0;
	    }
		
		return points;
	}
	
	private int flush(List<Card> hand, Card start, boolean isCrib){
		int points = 0;
		int occurence = 0;
		
		if(isCrib){
			for(Card i: hand){
				if(i.getSuit() == start.getSuit()){
					occurence += 1;
				}
			}
			points = occurence == 4 ? 5:0;
		} else {
			Card test = hand.get(0);
			for(Card i: hand.subList(1, hand.size())){
				if(i.getSuit() == test.getSuit()){
					occurence +=1;
				}
			}
			points = occurence == 3 ? 4:0;
			
			points += test.getSuit() == start.getSuit() ? 1:0;
		}
		
		
		return points;
	}
	private int runs(List<Card> runHand){
		int points = 0;
		List<Card> sorted = sort(runHand, on(Card.class).getNumber());
		int consecutive = 0;
		boolean doubles = false;
		List<Card> run = new LinkedList<Card>();
		
		for(int i = 0; i <sorted.size()-1;i++){
			int j = sorted.get(i).getNumber();
			int k = sorted.get(i+1).getNumber();
			
			if(j+1 == k){
				consecutive++;
			} 
		}
		
		if(consecutive >=3){
			
		}
		
		return points;
	}

}
