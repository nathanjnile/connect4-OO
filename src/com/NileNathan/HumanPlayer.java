package com.NileNathan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

    private BufferedReader input;

    public HumanPlayer(char counter) {
        super(counter);
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getUserInput(){
        String toReturn = null;
        try{
            toReturn = input.readLine();
        }
        catch(Exception e){
            System.out.println("Wrong input");
        }
        return toReturn;
    }
}
