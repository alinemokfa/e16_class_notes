package com.example.allymcgilloway.blackjack_start;

import org.junit.Before;
import org.junit.Test;

import dalvik.annotation.TestTarget;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class TestPlayer {

    Player player;
    Card card;

    @Before
    public void setup() {
        player = new Player("Ally");
        card = new Card(Suit.HEARTS, Rank.NINE);
    }

    @Test
    public void playerCanGetTotalValue() {
        Card otherCard = new Card(Suit.CLUBS, Rank.FIVE);
        player.takeCard(otherCard);
        player.takeCard(card);

        assertEquals(14, player.getTotalValueOfCards());
    }

    @Test
    public void canGetName() {
        assertEquals("Ally", player.getName());
    }

    @Test
    public void playerStartsWithZeroCards() {
        assertEquals(0, player.getNumberOfCards());
    }

    @Test
    public void canTakeCard() {
        player.takeCard(card);
        assertEquals(1, player.getNumberOfCards());
    }
}
