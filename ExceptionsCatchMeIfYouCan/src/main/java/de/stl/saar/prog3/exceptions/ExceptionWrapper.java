package de.stl.saar.prog3.exceptions;

public class ExceptionWrapper extends RuntimeException {
	private Exception originalException;
	
	public ExceptionWrapper(Exception originalException) {
		this.originalException = originalException;
	}
	
	public void rethrow() throws Exception {
		throw originalException;
	}
}
