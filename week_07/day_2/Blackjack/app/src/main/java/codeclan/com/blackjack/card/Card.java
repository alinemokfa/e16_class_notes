package codeclan.com.blackjack.card;

/**
 * Created by user on 07/11/2017.
 */

public class Card {
    Suit suit;
    Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return this.rank.getValue();
    }
}
