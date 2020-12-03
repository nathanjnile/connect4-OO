package com.NileNathan;

import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(char counter) {
        super(counter);
    }

    public String getUserInput(){
        Random rand = new Random();
        return Integer.toString(1 + rand.nextInt(7));
    }
}
