package proj3; // do not erase. Gradescope expects this.

public class Card {
    String suite;
    int rank;
    

    public Card(String suite, int rank) {
        this.suite = suite;
        this.rank = rank;

    }

    public String getSuite() {
        return suite;
    }

    public int getRank() {
        return rank;
    }

    public String toString() {
        return rank + " " + "of" + " " + suite;
    }

    public static void main(String[] args) {
        Card c = new Card("clubs", 6);
        System.out.println(c);
    }

}
