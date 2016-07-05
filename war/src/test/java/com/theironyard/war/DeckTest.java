package com.theironyard.war;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nigel on 6/26/16.
 */
public class DeckTest {

    @Test
    public void CreateADeckOf52Cards(){
        Deck warDeck = Deck.makeStandardDeck();

        assertEquals("Deck has more than or less than 52 cards.", warDeck.getSize(), 52);
    }
}