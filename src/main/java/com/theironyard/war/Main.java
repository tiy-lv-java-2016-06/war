package com.theironyard.war;

import java.util.Scanner;

/**
 * Created by Nigel on 6/23/16.
 */
public class Main {
    public static void main(String[] args) {
        String name;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Player 1, please enter your name: ");
        Player player1 = new Player(userInput.nextLine());
        System.out.println("Player 2, please enter your name: ");
        Player player2 = new Player(userInput.nextLine());

        Game war = new Game(player1, player2);
        war.startRound();
    }
}
