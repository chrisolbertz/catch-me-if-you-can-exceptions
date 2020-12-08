package de.stl.saar.prog3.exceptions;

public class IntroductionUnchecked {
	public static void main(String[] args) {
		System.out.println("Interessanter Code");		
		try {
			throwException();
			System.out.println("Wird nur ausgeführt, wenn keine Ausnahme geworfen wurde.");
		} catch (IllegalArgumentException ex) {
			System.out.println("Ausnahme gefangen: " + 
					ex.getMessage());
		}
		
		System.out.println("Noch mehr interessanter Code");
	}
	
	public static void throwException() {
		int i = 1;
		
		if (i == 0) {
			throw new IllegalArgumentException(
					"i darf nicht 0 sein!");
		}
	}
}
