package de.stl.saar.prog3.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileProcessingComponent{
    private final ExceptionHandler exceptionHandler;
    
    public MyFileProcessingComponent(ExceptionHandler exceptionHandler) {
		super();
		this.exceptionHandler = exceptionHandler;
	}

    public void processFile(String fileName){
        FileInputStream input = null;
        try{
            input = new FileInputStream(fileName);
            processStream(input);
        } catch (IOException ex){
            this.exceptionHandler.handle(ex,
                "error processing file: " + fileName);
        }
    }

    private void processStream(InputStream input)
        throws IOException{
        // Mach was mit dem Stream.
    }
}