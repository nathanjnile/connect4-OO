package com.NileNathan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserPlayer extends Player {

    private BufferedReader input;

    public UserPlayer(char counter) {
        super(counter);
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getInputCounter(){
        // gets a user input value from the buffered reader and returns this String value
        String toReturn = null;
        try{
            System.out.print("Enter column: ");
            toReturn = input.readLine();
        }
        catch(Exception e){
            System.out.println("Wrong input, try again");
        }
        return toReturn;
    }
}
