package proj3;
import java.util.ArrayList;
import java.util.*;

public class CommunityCardSet {
    private int MAX_NUM_CARD = 5;
    public static ArrayList<Card> community_poker_hand;
    public CommunityCardSet(ArrayList<Card> cardList){
        community_poker_hand = new ArrayList<Card>();
        for(int i = 0; i < MAX_NUM_CARD;i++){
            addCard(cardList.get(i));
        }
    }

    public void addCard(Card card){
        community_poker_hand.add(card);
    }

    public Card getIthCard(int i){
        if(i >= 0){
            return community_poker_hand.get(i);
        }   
        else{
            return null;
        }
    }
}
