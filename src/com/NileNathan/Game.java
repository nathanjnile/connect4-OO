package com.NileNathan;

public class Game {

    public void playGame() {
        // set variable for if the game has been won
        boolean gameStatus = false;
        // Create board instance
        Board gameBoard = new Board();
        // Create instance of user player
        UserPlayer userPlayer = new UserPlayer('r');
        // Create instance of computer player
        ComputerPlayer computerPlayer = new ComputerPlayer('b');
        // set current player to human
        Player currentPlayer = userPlayer;

        // List instructions of the game
        listInstructions();

        // print board
        gameBoard.printBoard(userPlayer.getCounter(), computerPlayer.getCounter());

        // while loop to start the game properly
        while(!gameStatus) {
            // get input from user or computer
            String userInput = currentPlayer.getInputCounter();
            // move will be the column number used for placing the counter
            int move;
            // place counter in correct place
            try {
                move = Integer.parseInt(userInput);
                boolean placed = gameBoard.placeCounter(currentPlayer.getCounter(), move);
                // if a counter is not placed then loop without changing player
                if (!placed) continue;
            } catch (Exception NumberFormatException) {
                // catch if the user enters incorrect input and loop back to allow them to try again
                System.out.println("Wrong input, try again");
                continue;
            }
            // check if 4 in a row is satisfied
            gameStatus = gameBoard.check4InARow(currentPlayer.getCounter());
            // print board only when computer has taken placed, this avoids the board printing too many times
            if(currentPlayer == computerPlayer) gameBoard.printBoard(userPlayer.getCounter(), computerPlayer.getCounter());
            // if the game has not been won then switch active player
            if(!gameStatus) {
                currentPlayer = switchPlayer(currentPlayer, userPlayer, computerPlayer);
            }
        }
        // print the winning board and message for winning counter colour
        gameBoard.printBoard(userPlayer.getCounter(), computerPlayer.getCounter());
        System.out.println("Congrats " + currentPlayer.getCounter() + " on winning!");
    }

    private void listInstructions() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and blue");
        System.out.println("Player 1 is Red, Player 2 is Blue");
        System.out.println("You are Player 1, and the computer is Player 2");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println(" ");
    }

    private Player switchPlayer(Player currentPlayer, Player humanPlayer, Player computerPlayer) {
        // method switchPlayer will return a Player reference to be assigned to the active player
        if(currentPlayer == humanPlayer) {
            currentPlayer = computerPlayer;
        } else {
            currentPlayer = humanPlayer;
        }
        return currentPlayer;
    }
}
