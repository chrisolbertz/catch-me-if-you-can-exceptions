package de.stl.saar.prog3.exceptions;

public interface ExceptionHandler {
	public void handle(final Exception e, 
					   final String errorMessage);
}
