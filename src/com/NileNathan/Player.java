package com.NileNathan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Player {

    private char counter;

    public Player(char counter) {
        this.counter = counter;
    }

    public char getCounter() {
        return counter;
    }

    public abstract String getInputCounter();
}
