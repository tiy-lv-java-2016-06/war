package com.theironyard.war;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nigel on 6/26/16.
 */
public class GameTest {
    Player player1 = new Player("p1");
    Player player2 = new Player("p2");

    @Test
    public void whenPlayersHandIsBigEnoughForWarReturnTrue() {
        Game game = new Game(player1, player2);
        boolean allowWar = game.allowWar();

        assertFalse("Should return false if one or both player do not have enough cards for war. but returned true.", allowWar);
    }

    @Test
    public void GameGetsSetupWithPlayersGettingTheirCardsAndDeckBeingCreated(){
        Game game = new Game(player1, player2);
        game.setupPlayers();
        assertEquals("Player 1 should have 26 cards in a 2 player game.", player1.getHandSize(), 26);
        assertEquals("Player 2 should have 26 cards in a 2 player game.", player2.getHandSize(), 26);
    }
}