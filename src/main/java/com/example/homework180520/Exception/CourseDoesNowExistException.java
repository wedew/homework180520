package com.example.homework180520.Exception;

public class CourseDoesNowExistException extends Exception {
    public CourseDoesNowExistException() {
        super("course does not exist..");
    }
}
