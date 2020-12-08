package de.stl.saar.prog3.exceptions;

import java.util.Optional;

public class Computer {
    private Double price;
 
    public Computer(Double price) {
        this.price = price;
    }
    
	public Double getPrice() {
		return price;
	}
	
	public static boolean priceIsInRange1(
			final Computer computer) {
		boolean isInRange = false;
	 
	    if (computer != null && computer.getPrice() != null
	      && (computer.getPrice() >= 1000
	        && computer.getPrice() <= 1500)) {
	 
	        isInRange = true;
	    }
	    return isInRange;
	}
	
	public static boolean priceIsInRange2(
			final Computer computer) {
	     return Optional.ofNullable(computer)
	       .map(Computer::getPrice)
	       .filter(price -> price >= 1000)
	       .filter(price -> price <= 1500)
	       .isPresent();
	 }
}