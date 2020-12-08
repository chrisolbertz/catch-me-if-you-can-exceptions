package de.stl.saar.prog3.exceptions;

import java.io.IOException;

public class GenericExceptionTest {
	public static void main(String[] args) {
		GenericExceptionInterface<IOException> objectWithIOException = new MyClassUsingGenericException();
		
		try {
			objectWithIOException.doSomething();
		} catch (IOException e) {
			// Tue etwas sinnvolles zur Fehlerbehandlung.
		}
	}
}
