package com.bridgelabz.exception;

public class MoodAnalyserException extends RuntimeException {

    public MoodAnalyserException(ExceptionType type,Throwable cause) {
        super(cause);
        this.type = type;
    }

    public MoodAnalyserException(ExceptionType type,String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public enum ExceptionType{
        IS_EMPTY,NO_SUCH_FIELD,NO_ARGUMENT,FIELD_INVOCATION_ISSUE,IS_NULL,NO_SUCH_CLASS,NO_SUCH_METHOD,ILLEGAL_ACCESS,INSATANTIATION_EXCEPTION,INVOCATION_TARGET_EXCEPTION;
    }
    public ExceptionType type;

    public MoodAnalyserException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
