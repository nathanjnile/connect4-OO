package com.NileNathan;

import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(char counter) {
        super(counter);
    }

    public String getInputCounter(){
        // returns a random value between 1-7
        Random rand = new Random();
        return Integer.toString(1 + rand.nextInt(7));
    }
}
