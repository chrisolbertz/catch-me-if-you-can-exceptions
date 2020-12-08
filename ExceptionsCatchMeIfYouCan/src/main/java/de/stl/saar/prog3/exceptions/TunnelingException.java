package de.stl.saar.prog3.exceptions;

public class TunnelingException extends RuntimeException {
	TunnelingException(Exception inner) {
		super(inner);
	}
}