package com.bridgelabz.exception;

public class MoodAnalyserException extends RuntimeException {

    public enum ExceptionType{
        IS_EMPTY,IS_NULL
    }
    public ExceptionType type;

    public MoodAnalyserException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
