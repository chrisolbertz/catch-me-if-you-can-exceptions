package de.stl.saar.prog3.exceptions;

public class WrappingHandler implements ExceptionHandler{
    public void handle(Exception e, String message){
        throw new RuntimeException(message, e);
    }
}