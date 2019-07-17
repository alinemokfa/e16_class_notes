package com.example.allymcgilloway.blackjack_start;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class Player {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalValueOfCards() {
        int totalValue = 0;

        for(Card card : this.cards) {
            totalValue += card.getValue();
        }

        return totalValue;
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

    public void takeCard(Card card){
        this.cards.add(card);
    }
}
