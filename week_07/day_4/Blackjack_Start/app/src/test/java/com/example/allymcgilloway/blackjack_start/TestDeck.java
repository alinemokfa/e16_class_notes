package com.example.allymcgilloway.blackjack_start;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class TestDeck {

    Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void canGenerateDeck(){
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void canGetCard(){
        Card card = deck.removeCard();
        assertEquals(Suit.CLUBS, card.getSuit());
        assertEquals(Rank.KING, card.getRank());
    }
}
