package com.theironyard.war;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nigel on 6/23/16.
 */
public class Player {
    private List<Card> hand = new ArrayList();
    private String name;

    public Player(String newName){
        this.name = newName;
    }

    public String getName(){
        return name;
    }

    public Card giveCard(){
        Card cardToGive;
        cardToGive = hand.get(0);
        hand.remove(0);
        return cardToGive;
    }

    public void takeCard(Card cardToTake){
        hand.add(cardToTake);
    }

    public int getHandSize(){
        return hand.size();
    }

    public int getCardValue(int index){
        return hand.get(index).getRank().getValue();
    }

    public String getCardInfo(int index){
        return hand.get(index).cardName();
    }
}
