package de.stl.saar.prog3.exceptions;

import java.util.Optional;

public class Person {
    public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
    private int age;
    private String password;
 
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
 
    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }
 
    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }
}