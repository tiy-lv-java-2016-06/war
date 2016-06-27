package com.theironyard.war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by EddyJ on 6/23/16.
 */
public class Player {
    String name;
    List<Card> hand = new ArrayList<Card>();

    public Player(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shuffleHand(){
        Collections.shuffle(hand);
    }

    /**
     * The method is creating a variable (givenCard) and assigning the first card in the player's
     * list to be returned when called.
     * @return givenCard is returning the first (top) card on the player's hand
     */
    public Card giveCard(){
        Card givenCard;
        givenCard = hand.get(0);
        hand.remove(0);
        return givenCard;
    }
}
