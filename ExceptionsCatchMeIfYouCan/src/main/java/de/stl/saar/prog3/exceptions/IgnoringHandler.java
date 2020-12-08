package de.stl.saar.prog3.exceptions;

public class IgnoringHandler implements ExceptionHandler{
    public void handle(final Exception e, 
    				   final String message) {
        // Nichts tun, sondern Exception 
    	// einfach ignorieren.
    }
}
