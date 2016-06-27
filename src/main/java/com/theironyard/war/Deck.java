package com.theironyard.war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by EddyJ on 6/23/16.
 */
public class Deck {
    private List<Card> cards = new ArrayList<Card>();

    public Deck(){

    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card dealCards(){
        return cards.remove(0);
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * The method calls for the 4 suits and ranks from the Enums (suits,ranks) and lists them together,
     * 1 suit for each rank until all 52 cards are made and returned.
     * @return going to return a deck of 52 cards for the players to use
     */
    public static Deck createStandardDeck(){
        Deck deck = new Deck();

        for(Suits suit : Suits.values()){
            for(Rank rank : Rank.values()){
                deck.addCard(new Card(suit, rank));
            }
        }
        return deck;
    }

}
