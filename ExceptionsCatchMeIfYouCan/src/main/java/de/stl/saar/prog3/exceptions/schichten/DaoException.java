package de.stl.saar.prog3.exceptions.schichten;

public class DaoException extends Exception {
	private static final String MESSAGE = "Ich bin eine Checked Exception!";
	
	public DaoException() {
		super(MESSAGE);
	}
}
