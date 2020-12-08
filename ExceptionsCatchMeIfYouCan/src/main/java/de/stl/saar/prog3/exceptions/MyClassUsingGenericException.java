package de.stl.saar.prog3.exceptions;

import java.io.IOException;

public class MyClassUsingGenericException implements GenericExceptionInterface<IOException> {

	@Override
	public void doSomething() throws IOException {
		// Tue etwas interessantes mit Dateien.
	}
}
