package de.stl.saar.prog3.exceptions;

public interface GenericExceptionInterface <E extends Exception> {
	void doSomething() throws E;
}