package de.stl.saar.prog3.exceptions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceExceptions {
	private static void printFile() throws IOException {
	    InputStream input = null;

	    try {
	        input = new FileInputStream("file.txt");

	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    } finally {
	        if(input != null){
	            input.close();
	        }
	    }
	}
	
	private static void printFileJava7() throws IOException {

	    try(FileInputStream input = new FileInputStream("file.txt")) {

	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	}	
	
	private static void printFileJava7Multiple() throws IOException {

	    try(  FileInputStream     input         = new FileInputStream("file.txt");
	          BufferedInputStream bufferedInput = new BufferedInputStream(input)
	    ) {

	        int data = bufferedInput.read();
	        while(data != -1){
	            System.out.print((char) data);
	    data = bufferedInput.read();
	        }
	    }
	}	
}
