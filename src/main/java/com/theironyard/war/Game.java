package com.theironyard.war;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nigel on 6/24/16.
 */
public class Game {
    Player player1;
    Player player2;
    public static final int TOPOFDECK = 0;
    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Sets up the Deck and player's hands.
     */
    public void setupPlayers(){

        //Setup Deck for players
        Deck warDeck = Deck.makeStandardDeck();
        warDeck.shuffle();
        int deckSize = warDeck.getSize();

        //Setup player hands.
        System.out.format("There are %s Cards in the deck :)\n", deckSize);
        while (warDeck.getSize() > 0){//for (int i = deckSize; i >= 0; i--){
            //System.out.println(i);
            player1.takeCard(warDeck.dealCard());
            player2.takeCard(warDeck.dealCard());
        }

        System.out.format("%s has %d cards\n", player1.getName(), player1.getHandSize());
        System.out.format("%s has %d cards\n", player2.getName(), player2.getHandSize());

    }

    /**
     * Starts each round of the game. Check for a winner a winner of each round and calls declareWinner() & war().
     */
    public void startRound(){
        boolean gameOver = false;
        setupPlayers();

        int roundCounter = 0;
        do {
            roundCounter++;
            System.out.printf("\n********** Round %d **********\n", roundCounter);
            System.out.format("%s has %d cards, plays %s\n", player1.getName(), player1.getHandSize(), player1.getCardInfo(TOPOFDECK));
            System.out.format("%s has %d cards, plays %s\n", player2.getName(), player2.getHandSize(), player2.getCardInfo(TOPOFDECK));

            if (player1.getCardValue(TOPOFDECK)> player2.getCardValue(TOPOFDECK)) {
                System.out.format("%s wins with %s\n", player1.getName(), player1.getCardInfo(TOPOFDECK));
                player1.takeCard(player2.giveCard());
                gameOver = (player2.getHandSize() == 0);
            } else if (player2.getCardValue(TOPOFDECK) > player1.getCardValue(TOPOFDECK)) {
                System.out.format("%s wins with %s\n", player2.getName(), player2.getCardInfo(TOPOFDECK));
                player2.takeCard(player1.giveCard());
                gameOver = (player1.getHandSize() == 0);
            }else if (allowWar()){
                war(player1, player2);
            }
            else
                gameOver = true;
        }while(gameOver == false);
        declareWinner();
    }

    /**
     * Runs the war part of the game. If chooses a winner and gives them the cards in the pot.
     * @param player1 - first player
     * @param player2 - second player
     */
    public void war(Player player1, Player player2){
        List<Card> winnersPot = new ArrayList<Card>();
        System.out.println("\n********** WAR!!! Get SOME! **********");
        for (int i = 0; i < 4; i++) {
            winnersPot.add(player1.giveCard());
            winnersPot.add(player2.giveCard());
        }

        System.out.format("%s has %d cards, plays %s\n", player1.getName(), player1.getHandSize(), player1.getCardInfo(TOPOFDECK));
        System.out.format("%s has %d cards, plays %s\n", player2.getName(), player2.getHandSize(), player2.getCardInfo(TOPOFDECK));

        if (player1.getCardValue(TOPOFDECK)> player2.getCardValue(TOPOFDECK)){
            System.out.format("%s wins with %s\n", player1.getName(), player1.getCardInfo(TOPOFDECK));
            for (Card card : winnersPot) {
                player1.takeCard(card);
            }
            player1.takeCard(player2.giveCard());
        }else if (player2.getCardValue(TOPOFDECK) > player1.getCardValue(TOPOFDECK)){
            System.out.format("%s wins with %s\n", player2.getName(), player2.getCardInfo(TOPOFDECK));
            for (Card card : winnersPot) {
                player2.takeCard(card);
            }
            player2.takeCard(player1.giveCard());
        }else{
            war(player1, player2);
        }
    }

    public void declareWinner() {
        if (player1.getHandSize() > player2.getHandSize()) {
            System.out.format("%s Wins!!", player1.getName());
        } else {
            System.out.format("%s Wins!!", player2.getName());
        }
    }

    public boolean allowWar() {
        boolean allowWar = true;
        if (player1.getHandSize() < 5 || player1.getHandSize() < 5) {
            allowWar = false;
            if (player1.getHandSize() < 5) {
                System.out.printf("%s does not have enough cards for War.\n", player1.getName());
            } else {
                System.out.printf("%s does not have enough cards for War.\n", player2.getName());
            }
        }
        return allowWar;
    }
}