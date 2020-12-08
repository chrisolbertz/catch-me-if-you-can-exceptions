package de.stl.saar.prog3.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UglyExceptionUse {
	public void hideousArrayOutOfBoundsException() {
		int [] myArray = {2,3,4,5,6,7};
		try {
			int i = 0;
			while(true) {
				i++;
				System.out.println(myArray[i]);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
		}
	}
	
	public void correctLoopThroughAnArray() {
		int [] myArray = {2,3,4,5,6,7};
		
		for (final int i: myArray) {
			System.out.println(myArray[i]);
		}
	}
	
	public void ignoredException() {
		try {
			methodThatThrowsAnIllegalArgumentException();
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	private void methodThatThrowsAnIllegalArgumentException() {
		throw new IllegalArgumentException();
	}
	
	public void thisExceptionCanBeIgnored() {
		final File myFile = new File("bla.txt");
		try {
			final InputStream inputStream = 
					new FileInputStream(myFile);
		} catch (FileNotFoundException ignored) {
			// Kann nicht auftreten, da die Datei 
			//vorher angelegt wird.
		}
	}
	
	/*public long hideousArrayOutOfBoundsException() {
		int [] myArray = createRandomIntArray();
		final long startTime = System.currentTimeMillis();
		
		try {
			int i = 0;
			while(true) {
				i++;
				int x = myArray[i];
			}
		} catch(ArrayIndexOutOfBoundsException e) {
		}
		final long endTime = System.currentTimeMillis();
		final long duration = endTime - startTime;
		System.out.println("Dauer mit Exception: " + duration + " Millis");
		return duration;
	}
	
	public long correctLoopThroughAnArray() {
		int [] myArray = createRandomIntArray();
		final long startTime = System.currentTimeMillis();
		
		for (final int i: myArray) {
			int x = myArray[i];
		}
		
		final long endTime = System.currentTimeMillis();
		final long duration = endTime - startTime;
		System.out.println("Dauer ohne Exception: " + duration + " Millis");
		return duration;
	}
	
	private int[] createRandomIntArray() {
		final Random random = new Random();
		int [] myArray = new int [SIZE];
		for(int i = 0; i < SIZE; i++) {
			myArray[i] = random.nextInt(SIZE);
		}
		
		return myArray;
	}*/
}
