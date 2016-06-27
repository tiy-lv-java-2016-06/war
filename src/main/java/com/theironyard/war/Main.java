package com.theironyard.war;

/**
 * Created by EddyJ on 6/23/16.
 */
public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Bob");
        Player player2 = new Player("Bill");
        Game game = new Game(player1, player2);
        System.out.println("Let's play War!!");
        game.setUpHands();
        game.runGame();
        game.gameOver();
    }
}
