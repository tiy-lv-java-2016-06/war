package com.theironyard.war;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by EddyJ on 6/26/16.
 */
public class GameTest {

    @Test
    public void whenSetUpHandsThenHandEquals26(){
        Player player1 = new Player("TestPlayer1");
        Player player2 = new Player("TestPlayer2");

        assertTrue("Player1's hand should equal 26", player1.hand.size() == 0);
        assertTrue("Player2's hand should equal 26", player2.hand.size() == 0);
    }
    @Test
    public void whenRunGameThenDeclareWinner(){
        Player player1 = new Player("TestPlayer1");
        Player player2 = new Player("TestPlayer2");

        assertTrue("player1 should be declared winner if other player is out of cards", player2.hand.size() == 0);
        assertTrue("player2 should be winner if other player is out of cards", player1.hand.size() == 0);

        
    }

}
