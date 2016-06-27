package com.theironyard.war;

/**
 * Created by Nigel on 6/23/16.
 */
public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String cardName() {
        return String.format("%s of %s", rank, suit);
    }
}

