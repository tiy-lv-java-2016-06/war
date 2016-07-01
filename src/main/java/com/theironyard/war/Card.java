package com.theironyard.war;

/**
 * Created by EddyJ on 6/23/16.
 */
public class Card {

    private Suits suit;
    private Rank rank;

    public Card(Suits suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString(){
        return String.format("%s of %s\n", rank, suit);
    }

}
