package com.NileNathan;

public class Game {

    public void playGame() {
        // set variable for if the game has been won
        boolean gameStatus = false;
        // Create board instance
        Board gameBoard = new Board();
        View gameView = new CLIView();
        // Create instance of user player
        UserPlayer userPlayer = new UserPlayer('r');
        // Create instance of computer player
        ComputerPlayer computerPlayer = new ComputerPlayer('b');
        // set current player to human
        Player currentPlayer = userPlayer;

        // List instructions of the game
        gameView.listInstructions();

        // print board
        gameView.printBoard(gameBoard, userPlayer.getCounter(), computerPlayer.getCounter());

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
            if(currentPlayer == computerPlayer) gameView.printBoard(gameBoard, userPlayer.getCounter(), computerPlayer.getCounter());
            // if the game has not been won then switch active player
            if(!gameStatus) {
                currentPlayer = switchPlayer(currentPlayer, userPlayer, computerPlayer);
            }
        }
        // print the winning board and message for winning counter colour
        gameView.printBoard(gameBoard, userPlayer.getCounter(), computerPlayer.getCounter());
        System.out.println("Congrats " + currentPlayer.getCounter() + " on winning!");
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
