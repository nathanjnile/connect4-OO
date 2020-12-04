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
