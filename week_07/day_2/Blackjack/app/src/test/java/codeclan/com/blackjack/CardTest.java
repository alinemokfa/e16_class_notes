package codeclan.com.blackjack;

import org.junit.Test;

import codeclan.com.blackjack.card.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 07/11/2017.
 */

public class CardTest {
    @Test
    public void testCardHasValue() {
        Card card = new Card(Suit.CLUBS, Rank.EIGHT);

        int actual = card.getValue();

        assertEquals(8, actual);
    }
}
