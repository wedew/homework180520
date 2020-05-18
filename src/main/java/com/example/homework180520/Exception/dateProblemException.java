package com.example.homework180520.Exception;

public class dateProblemException extends Exception {
    public dateProblemException() {
        super("the date entered is too old");
    }
}
