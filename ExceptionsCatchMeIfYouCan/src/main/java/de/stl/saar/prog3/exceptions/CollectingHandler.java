package de.stl.saar.prog3.exceptions;

import java.util.ArrayList;
import java.util.List;

public class CollectingHandler implements ExceptionHandler {
	List<Exception> exceptions = new ArrayList<>();

	public List<Exception> getExceptions() {
		return this.exceptions;
	}

	public void handle(Exception e, String message) {
		this.exceptions.add(e);
	}
}