package com.theironyard.war;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EddyJ on 6/23/16.
 */
public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * The method is going to set up each players hand of 26 random cards from the standard deck of 52 cards.
     */
    public void setUpHands() {
        Deck deck = new Deck();
        deck = Deck.createStandardDeck();
        deck.shuffle();
        for (int i = 1; i <= 26; i++) {
            player1.hand.add(deck.dealCards());
            player2.hand.add(deck.dealCards());
        }
    }

    /**
     * The method runs the game after the players have their hands dealt to them from the
     * method "setUpHands" and continues to run while the players still have cards available to use.
     */
    public void runGame() {
        int round = 0;
        while ((player1.hand.size() != 0 || (player2.hand.size() != 0))) {
            round++;
            System.out.format("******** Round %d Starting ********\n", round);
            battle();
            if (player1.hand.size() == 0) {
                System.out.format("%s you are the winner!\n", player2.getName());
                break;
            } else if (player2.hand.size() == 0) {
                System.out.format("%s you are the winner!\n", player1.getName());
                break;
            }
        }
    }

    /**
     * If the players' card are equal in rank(value) then they must go to "war" and this method is called.
     * The method requires both players to give 4 cards in a war pile and play a 5th card after to see who wins
     * the pile. If a player runs out of cards at anytime, it is gameover.
     */
    public void runWar() {
        ArrayList<Card> warPile = new ArrayList<Card>();
        System.out.println("--------- Its time for WAR!!!!! ---------");
        for (int i = 0; i < 4; i++) {
            warPile.add(player1.giveCard());
            warPile.add(player2.giveCard());
            if (player1.hand.size() == 0) {
                System.out.format("%s you are the winner!\n", player2.getName());
                return;
            } else if (player2.hand.size() == 0) {
                System.out.format("%s you are the winner!\n", player1.getName());
                return;
            }
        }
        Card player1Card = player1.giveCard();
        Card player2Card = player2.giveCard();
        System.out.format("%s plays %s\n", player1.getName(), player1Card.toString());
        System.out.format("%s plays %s\n", player2.getName(), player2Card.toString());
        Rank player1Rank = player1Card.getRank();
        Rank player2Rank = player2Card.getRank();
        if (player1Rank.getValue() > player2Rank.getValue()) {
            System.out.format("%s won the War!\n", player1.getName());
            player1.hand.add(player2Card);
            player1.hand.add(player1Card);
            player1.hand.addAll(warPile);
            player1.shuffleHand();
        } else if (player1Rank.getValue() < player2Rank.getValue()) {
            System.out.format("%s won the War!\n", player2.getName());
            player2.hand.add(player1Card);
            player1.hand.add(player2Card);
            player2.hand.addAll(warPile);
            player2.shuffleHand();
        } else if (player1Rank.getValue() == player2Rank.getValue()) {
            runWar();
        } else {
            runGame();
        }
    }

    /**
     * During the battle method each player draws the top card of their hand and plays it. After comparing the rank
     * of the cards, whomever has the higher rank wins both cards and the method continues to play until someone runs
     * out of cards to play. If the rank is the same, another method is called, runWar, to see who is the winner of
     * that round.
     */
    public void battle() {
        if (player1.hand.size() == 0 || player2.hand.size() == 0) {
            runGame();
        } else {
            Card player1Card = player1.giveCard();
            Card player2Card = player2.giveCard();
            System.out.format("%s plays %s\n", player1.getName(), player1Card.toString());
            System.out.format("%s plays %s\n", player2.getName(), player2Card.toString());
            Rank player1Rank = player1Card.getRank();
            Rank player2Rank = player2Card.getRank();
            if (player1Rank.getValue() > player2Rank.getValue()) {
                System.out.format("%s won the Round!\n", player1.getName());
                player1.hand.add(player2Card);
                player1.hand.add(player1Card);
                player1.shuffleHand();
            } else if (player1Rank.getValue() < player2Rank.getValue()) {
                System.out.format("%s won the Round!\n", player2.getName());
                player2.hand.add(player1Card);
                player2.hand.add(player2Card);
                player2.shuffleHand();
            } else {
                runWar();
            }
        }
    }

    public void gameOver(){
        System.out.println("Gameover");
    }
}