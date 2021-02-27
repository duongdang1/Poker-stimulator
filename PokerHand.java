package proj3; // do not erase. Gradescope expects this.

import java.util.ArrayList;

public class PokerHand {
    private int MAX_CARD_IN_HAND = 5;
    private ArrayList<Card> poker_hand;
    private static int SIZE = 4;
    
    public PokerHand(ArrayList<Card> cardList) {
        poker_hand = new ArrayList<Card>();
        for (int k = 0; k < MAX_CARD_IN_HAND; k++) {
            addCard(cardList.get(k));
        }
        handSort(poker_hand);

    }

    public void addCard(Card card) {
        poker_hand.add(card);
    }

    public static ArrayList<Card> handSort(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            int j = i;
            for (int k = i + 1; k < hand.size(); k++) {
                if (hand.get(k).getRank() <= hand.get(j).getRank()) {
                    j = k;
                }
            }
            Card temp = hand.get(j);
            hand.set(j, hand.get(i));
            hand.set(i, temp);
        }
        return hand;
    }

    public Card get_ith_card(int i) {
        if (i >= 0) {
            return poker_hand.get(i);
        } else {
            return null;
        }
    }

    public int checkPair(ArrayList<Card> hand) {
        int COUNT = 0;
        for (int i = 0; i <= SIZE - 1; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                COUNT += 1;
            }

        }
        if (COUNT == 1) {
            return 1;
        }
        return 0;
    }

    public int checkTwoPair(ArrayList<Card> hand) {
        int COUNTP = 0;
        for (int i = 0; i <= SIZE - 1; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                COUNTP += 1;
            }

        }
        if (COUNTP == 2) {
            return 2;
        }
        return 0;
    }

    public int checkFlush(ArrayList<Card> hand) {
        int COUNTF = 0;
        for (int i = 0; i <= SIZE; i++) {
            if (hand.get(0).getSuite().equals(hand.get(i).getSuite())) {
                COUNTF += 1;
            }

        }
        if(COUNTF == 5){
            return 3;
        }
        
        return 0;
    }

    public int compareTo(PokerHand other) {
        int check_pair = checkPair(poker_hand);
        int check_two_pair = checkTwoPair(poker_hand);
        int check_flush = checkFlush(poker_hand);
        int value_hand = check_pair + check_two_pair + check_flush;
        int check_other_pair = other.checkPair(other.poker_hand);
        int check_other_two_pair = other.checkTwoPair(other.poker_hand);
        int check_other_flush = other.checkFlush(other.poker_hand);
        int value_other_hand = check_other_pair + check_other_two_pair + check_other_flush;
        if (value_hand > value_other_hand) {
            return 1;
        }
        else if(value_hand == value_other_hand){
            for(Card card : poker_hand){
                for(Card card1: other.poker_hand){
                    if(card.getRank() > card1.getRank()){
                        return 1;
                    }else if(card.getRank() == card1.getRank()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    public String toString(){
        return "this is a hand" + poker_hand;
    }

    public static void main(String[] args) {

        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("diamonds", 5));
        hand.add(new Card("clubs", 4));
        hand.add(new Card("hearts", 5));
        hand.add(new Card("clubs", 9));
        hand.add(new Card("spades", 4));
        PokerHand p = new PokerHand(hand);

        ArrayList<Card> other_hand = new ArrayList<Card>();
        other_hand.add(new Card("diamonds", 2));
        other_hand.add(new Card("spades", 5));
        other_hand.add(new Card("clubs", 2));
        other_hand.add(new Card("hearts", 9));
        other_hand.add(new Card("clubs", 5));
        
        PokerHand other_poker_hand = new PokerHand(other_hand);
        System.out.println(p.compareTo(other_poker_hand));
        System.out.println(p.poker_hand.toString());

    }

}
