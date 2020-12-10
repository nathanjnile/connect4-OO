package com.NileNathan;

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
