package de.stl.saar.prog3.exceptions;

import java.io.IOException;

public class IntroductionChecked {
	public static void main(String[] args) {
		System.out.println("Interessanter Code");		
		try {
			throwException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Noch mehr interessanter Code");
	}
	
	public static void throwException() throws IOException {
		int i = 1;
		
		if (i == 0) {
			throw new IOException("i darf nicht 0 sein!");
		}
	}
}
