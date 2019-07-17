package codeclan.com.blackjack;

import org.junit.Test;

import codeclan.com.blackjack.card.Card;
import codeclan.com.blackjack.card.Deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 07/11/2017.
 */

public class DeckTest {
    @Test
    public void testSetup() {
        Deck deck = new Deck();
        deck.setup();
        assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void testgetNextCard() {
        Deck deck = new Deck();
        deck.setup();

        Card card = deck.nextCard();

        //Because card does not have any methods
        //to expose rank or suit
        //I could potentially just assert that it is not null
        //This may change as my code organically grows
        assertNotNull(card);
    }
}
