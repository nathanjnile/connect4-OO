package com.NileNathan;

public class CLIView implements View {

    public void printBoard(Board boardObject, char userCounter, char computerCounter) {
        char[][] board = boardObject.getBoard();
        // loops through the board matrix and prints the full board with placement of counters
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == userCounter){
                    System.out.print("| " + userCounter + " ");
                }
                else if(board[i][j] == computerCounter){
                    System.out.print("| " + computerCounter + " ");
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public void listInstructions() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and blue");
        System.out.println("Player 1 is Red, Player 2 is Blue");
        System.out.println("You are Player 1, and the computer is Player 2");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println(" ");
    }
}
