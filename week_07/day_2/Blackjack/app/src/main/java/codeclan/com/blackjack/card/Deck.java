package codeclan.com.blackjack.card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 07/11/2017.
 */

public class Deck {
    private ArrayList<Card> cards;

    /*
        If your constructor is empty. Remove it
        It is redundant. Java creates one for us

        public Deck() {
        }
     */

    public void setup() {
        this.cards = new ArrayList();

        Suit[] allSuits = Suit.values();
        Rank[] allRanks = Rank.values();

        for(Suit suit : allSuits) {
            for(Rank rank : allRanks) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    public void shuffle() {
        //There is a Collections class which has a static method
        //Remember: self.all()
        //Which is called shuffle which accepts an arraylist or array
        //This shuffles the array in place
        //Remember the ! operator for methods in ruby (array.map!)
        Collections.shuffle(this.cards);
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

    public Card nextCard() {
        //The remove method takes in an index and removes that
        //index from the array and returns it.
        Card card = this.cards.remove(0);
        return card;
    }
}
