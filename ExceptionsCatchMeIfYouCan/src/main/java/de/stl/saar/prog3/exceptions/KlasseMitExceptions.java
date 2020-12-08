package de.stl.saar.prog3.exceptions;

import java.io.IOException;

public class KlasseMitExceptions implements MeinInterface { 
	public void tueEtwas() throws IOException {
		// tue etwas mit Dateien und wirf eine
		// IOException.
		throw new IOException();
	}
}
