package com.NileNathan;

public class Board {

    private char[][] board;

    public Board() {
        board = new char[6][7];
    }

    public Board(int height, int width) {
        board = new char[height][width];
    }

    public boolean placeCounter(char playerCounter, int position){
        for(int i=board.length-1; i>=0; i--){
            // if empty place counter and return true
            if(board[i][position - 1] == Character.MIN_VALUE) {
                board[i][position - 1] = playerCounter;
                return true;
            }
        }
        System.out.println("Column full, nothing placed");
        return false;
    }

    public boolean check4InARow(char colour) {
        if(checkHorizontal(colour) || checkVertical(colour) || checkDiagonal(colour)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHorizontal(char colour) {
        for(int i=0; i<board.length; i++){
            int count = 0;
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == colour){
                    count = count + 1;
                    if(count >= 4){
                        return true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(char colour) {
        for(int i=0; i<board[0].length; i++){
            int count = 0;
            for(int j=0; j<board.length; j++) {
                if (board[j][i] == colour) {
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(char colour) {
        // check diagonal 4 in a rows
        // top left to half way
        for(int i = 0; i < board.length; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; k >= 0; j++) {
                if (board[k][j] == colour) {
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                k--;
            }
        }

        // half way to bottom right
        for(int j = 0; j < board[0].length; j++) {
            int count = 0;
            int k = j;
            for (int i = board.length - 1; k < board[0].length; i--) {
                if (i < 0) break;
                if (board[i][k] == colour) {
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                k++;
            }
        }

        // top right to half way
        for(int i = 0; i < board.length; i++) {
            int count= 0;
            int k = i;
            for (int j = board[0].length - 1; k >= 0; j--) {
                if (board[k][j] == colour) {
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                k--;
            }
        }


        // halfway to bottom left
        for(int j = board[0].length - 1; j >=0; j--) {
            int count = 0;
            int k = j;
            for (int i = board.length - 1; k >=0; i--) {
                if (i < 0) break;
                if (board[i][k] == colour) {
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                k--;
            }
        }

        return false;
    }

    public void printBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'r'){
                    System.out.print("| r ");
                }
                else if(board[i][j] == 'b'){
                    System.out.print("| b ");
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }


}
