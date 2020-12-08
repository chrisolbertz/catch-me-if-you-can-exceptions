package de.stl.saar.prog3.exceptions;

public class ExceptionAdapterTest {
	public static void main(String[] args) {
		try {
			try {
				throw new java.io.FileNotFoundException("Bla");
			} catch(Exception ex) {
				ex.printStackTrace();
				throw new ExceptionWrapper(ex);
			}   
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("That's all!");
	}
}