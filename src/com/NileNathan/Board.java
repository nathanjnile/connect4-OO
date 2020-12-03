package com.NileNathan;

public class Board {

    private char[][] board;

    public Board() {
        board = new char[6][7];
    }

    public Board(int height, int width) {
        board = new char[height][width];
    }

    public void placeCounter(char player, int position){
        boolean placed = false;
        if(player == 'r'){
            for(int i=board.length-1; i>=0; i--){
                if(!placed){
                    if(board[i][position - 1] == 'b'){
                        // skip
                    }
                    else if(board[i][position - 1] != 'r'){
                        board[i][position - 1] = 'r';
                        placed = true;
                    }
                }
            }
        }
        else{
            for(int i=board.length-1; i>=0; i--){
                if(!placed){
                    if(board[i][position-1] == 'r'){
                        // skip
                    }
                    else if(board[i][position-1] != 'b'){
                        board[i][position-1] = 'b';
                        placed = true;
                    }
                }
            }
        }
        if (!placed) {
            System.out.println("Column full, nothing placed");
        }
    }
}
