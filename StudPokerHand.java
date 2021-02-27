package proj3;

import java.util.ArrayList;

public class StudPokerHand {
    private int MAX_CARD_IN_STUD = 2;
    public ArrayList<Card> stud_poker_hand;
    private int NUM_CARD_IN_HAND = 6;
    private int SIZE = 5;
    private int COUNT = 0;
    
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        stud_poker_hand = new ArrayList<Card>();
        for (int i = 0; i < MAX_CARD_IN_STUD; i++) {
            addCard(cardList.get(i));
        }
    }

    public void addCard(Card card) {
        stud_poker_hand.add(card);
    }

    public Card getIthCardStud(int i) {
        if (i >= 0) {
            return stud_poker_hand.get(i);
        } else {
            return null;
        }
    } 
    private ArrayList<PokerHand> getAllFiveCardHands() {
        ArrayList<PokerHand> all_five_cards_hands = new ArrayList<PokerHand>();
        
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) { 
                ArrayList<Card> L = new ArrayList<Card>();
                L.addAll(stud_poker_hand);
                L.addAll(CommunityCardSet.community_poker_hand);
                
                L.remove(L.get(i));
                L.remove(L.get(j));
                PokerHand pokerHand = new PokerHand(L);
                if (!all_five_cards_hands.contains(pokerHand)){
                    all_five_cards_hands.add(pokerHand);
                }
                
               
            }
        }
        return all_five_cards_hands;

    }
    private PokerHand getBestFiveCardHand(){
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        
        return bestSoFar;
    }

    
    public int compareStudTo(StudPokerHand other){
        other.getAllFiveCardHands();
        PokerHand other_best_hand = other.getBestFiveCardHand();
        
        if (getBestFiveCardHand().compareTo(other_best_hand) > 0) {
            return 1;
        }
        else if (getBestFiveCardHand().compareTo(other_best_hand) == 0){
            return 0;
        }
        return -1;
    }

    public String toString(){
        return "this is a set of cards";
    }
    public static void main(String[] args) {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("diamonds", 5));
        hand.add(new Card("clubs", 4));
        hand.add(new Card("hearts", 7));
        hand.add(new Card("clubs", 9));
        hand.add(new Card("spades", 8));
        ArrayList<Card> stud_hand = new ArrayList<Card>();
        stud_hand.add(new Card("Hearts", 5));
        stud_hand.add(new Card("clubs", 10));
        ArrayList<Card> second_stud_hand = new ArrayList<Card>();
        second_stud_hand.add(new Card("Hearts",9));
        second_stud_hand.add(new Card("Hearts",8));
        
        CommunityCardSet cds = new CommunityCardSet(hand);
        StudPokerHand stud = new StudPokerHand(cds, stud_hand);
        StudPokerHand second_stud = new StudPokerHand(cds, second_stud_hand);
        System.out.println(stud.compareStudTo(second_stud));
    }
}


