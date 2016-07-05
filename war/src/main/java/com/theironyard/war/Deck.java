package com.theironyard.war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nigel on 6/23/16.
 */
public class Deck {
    private List<Card> cards = new ArrayList<Card>();

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int getSize() {
        return cards.size();
    }
    public Card dealCard(){
        return cards.remove(0);
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public static Deck makeStandardDeck(){
        Deck deck = new Deck();
        for(Suit suit : Suit.values()){ //This was confusing at first, but now it's pretty cool.
            for(Rank rank : Rank.values()){
                deck.addCard(new Card(rank, suit));
            }
        }
        return deck;
    }
}