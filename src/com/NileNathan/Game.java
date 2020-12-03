package com.NileNathan;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.ArrayList;

public class Game {

    public void playGame() {
        // List instructions of the game
        listInstructions();
        // Create board instance
        Board gameBoard = new Board();
        // Create instance of human player
        HumanPlayer humanPlayer = new HumanPlayer('r');
        // Create instance of computer player
        ComputerPlayer computerPlayer = new ComputerPlayer('b');

        // set current player to human
        Player currentPlayer = humanPlayer;

        // set variable for if the game has been won
        boolean gameStatus = false;

        // while loop to start the game properly
        while(!gameStatus) {
            // print board

            // get input from user or computer
            String userInput = currentPlayer.getUserInput();
//            System.out.println(userInput);
            int move;
            // place counter in correct place
            try {
                move = Integer.parseInt(userInput);
                gameBoard.placeCounter(currentPlayer.getCounter(), move);
            } catch (Exception NumberFormatException) {
                System.out.println("Wrong input");
                continue;
            }
            // check if 4 in a row is satisfied


            System.out.println(currentPlayer.getCounter());
            currentPlayer = switchPlayer(currentPlayer, humanPlayer, computerPlayer);
            // print board
        }






    }

    private void listInstructions() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
    }

    private Player switchPlayer(Player currentPlayer, Player humanPlayer, Player computerPlayer) {
        if(currentPlayer == humanPlayer) {
            currentPlayer = computerPlayer;
        } else {
            currentPlayer = humanPlayer;
        }
        return currentPlayer;
    }
}
