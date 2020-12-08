package de.stl.saar.prog3.exceptions;

import java.io.IOException;

public class MethodSignature {
	public static void main(String [] args) {
		
	}
	
	public void save() throws DataException {
		// Mache etwas mit Dateien
		try {
			saveInFile();
		} catch (IOException e) {
			throw new DataException();
		}
	}
	
	private void saveInFile() throws IOException {
		throw new IOException();
	}
	
	public class DataException extends Exception {
		
	}
	
}
