package proj3;

import java.util.ArrayList;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.ShuffleCards();
        int count = 0;

        ArrayList<Card> community_card = new ArrayList<Card>();
        ArrayList<Card> first_hand = new ArrayList<Card>();
        ArrayList<Card> second_hand = new ArrayList<Card>();
        for (int i = count; i < count + 5; i++) {
            community_card.add(d.Deal(i));
        }
        count += 5;
        for (int i = count; i < count + 2; i++) {
            first_hand.add(d.Deal(i));
        }
        count += 2;
        for (int i = count; i < count + 2; i++) {
            second_hand.add(d.Deal(i));
        }
        count += 2;
        CommunityCardSet cmc = new CommunityCardSet(community_card);
        StudPokerHand firstHand = new StudPokerHand(cmc,first_hand);
        StudPokerHand secondHand = new StudPokerHand(cmc,second_hand);
        int compare = firstHand.compareStudTo(secondHand);

        System.out.println("the community cards are" + community_card);
        System.out.println(first_hand);
        System.out.println(second_hand);
        Scanner obj = new Scanner(System.in);
        int a = obj.nextInt();
       
        System.out.println("first hand or second hand win?");
        if (a == compare){
            System.out.println("correct");
        }else{
            System.out.println("incorrect");
        }

        
        
        
    }
}
