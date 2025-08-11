package com.ben.exceptions;

public class YouDiedException extends RuntimeException {

    public YouDiedException() {
        super("You DIED. Game over.");
    }

}
