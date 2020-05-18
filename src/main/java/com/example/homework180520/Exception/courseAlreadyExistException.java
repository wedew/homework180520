package com.example.homework180520.Exception;

public class courseAlreadyExistException extends Exception {
    public courseAlreadyExistException() {
        super("the course title already been taken..");
    }
}
