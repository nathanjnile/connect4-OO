package com.NileNathan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Player {

    private char counter;

    public Player(char counter) {
        this.counter = counter;
    }

    public int moveCounter() {
        // get input from buffered input and return int
        return 1;
    }

    public char getCounter() {
        return counter;
    }

    public abstract String getUserInput();
}
