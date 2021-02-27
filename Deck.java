package proj3; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.*;


public class Deck {

    final int size = 52;
    ArrayList<Card> deckOfCards = new ArrayList<Card>();

    public Deck() {
        String[] suits = { "Diamonds", "Clubs", "Hearts", "Spades" };
        int[] ranks = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        for (String s : suits) {
            for (int r : ranks) {
                Card card = new Card(s, r);
                deckOfCards.add(card);
                
            }
        }
    }

    public void ShuffleCards() {
        Random rand = new Random();
        int j;
        for (int i = 0; i < size; i++) {
            j = rand.nextInt(52);
            Card temp = deckOfCards.get(i);
            deckOfCards.set(i,deckOfCards.get(j));
            deckOfCards.set(j,temp);
        }
        
    }

    public Card Deal(int nextToDeal) {
        
        if(deckOfCards.size() - nextToDeal >= 0){
            return deckOfCards.get(nextToDeal);
        }
        else{
            return null;
        }
        
    }
    public int Size(int nextToDeal){
        return deckOfCards.size() - nextToDeal;
    }

    public int Gather(int NextToDeal){
        NextToDeal = 0;
        return NextToDeal;
    }

    public boolean isEmpty(){
        if(deckOfCards.size() == 0){
            return true;
        }
        return false;
    }
   
    public void showCards() {
        System.out.println("---------------------------------------------");
        int count = 0;
        for (Card card : deckOfCards) {
            System.out.print(card.rank + " of " + card.suite + "     ");
            count++;
            if (count % 4 == 0)
                System.out.println("");
        }
        System.out.println("---------------------------------------------");
    
    }
    
    public String toString(){
        return "this is a deck of cards";
    }
    public static void main(String[] args) {
        
        
        Deck d = new Deck();

        d.ShuffleCards();
        d.showCards();
        System.out.println(d);
        
        
        
        

    }
}
