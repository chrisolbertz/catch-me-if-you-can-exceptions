package de.stl.saar.optionals;

import static de.stl.saar.prog3.exceptions.Computer.priceIsInRange1;
import static de.stl.saar.prog3.exceptions.Computer.priceIsInRange2;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

import org.junit.Test;

import de.stl.saar.prog3.exceptions.Computer;
import de.stl.saar.prog3.exceptions.Person;

public class OptionalTest {
	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
		final Optional<String> empty = Optional.empty();
	    assertFalse(empty.isPresent());
	}
	
	@Test
	public void givenNonNull_whenCreatesOptional_thenCorrect() {
	    final String name = "SystemTechnikLabor";
	    final Optional<String> optional = Optional.of(name);
	    assertTrue(optional.isPresent());
	    final String expectedString = "Optional[SystemTechnikLabor]";
	    final String actualString = optional.toString();
	    assertThat(expectedString, is(equalTo(actualString)));
	}
	
	@Test(expected = NullPointerException.class)
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
	    final String name = null;
	    final Optional<String> optional = Optional.of(name);
	}
	
	@Test
	public void givenNonNull_whenCreatesNullable_thenCorrect() {
	    String name = "SystemTechnikLabor";
	    Optional<String> optional = Optional.ofNullable(name);
	    assertTrue(optional.isPresent());
	    final String expectedString = "Optional[SystemTechnikLabor]";
	    final String actualString = optional.toString();
	    assertThat(expectedString, is(equalTo(actualString)));
	}
	
	@Test
	public void givenNull_whenCreatesNullable_thenCorrect() {
	    final String name = null;
	    final Optional<String> optional = Optional.ofNullable(name);
	    
	    assertFalse(optional.isPresent());
	    final String expectedString = "Optional.empty";
	    final String actualString = optional.toString();
	    assertThat(expectedString, is(equalTo(actualString)));
	}
	
	@Test
	public void givenNull_whenIfWorks_thenCorrect() {
		final String name = "SystemTechnikLabor";
		String actualName = null;
		final String expectedName = "SystemTechnikLabor-if";
		
		if (name != null) {
			actualName = name + "-if";
		} 
		
		assertThat(actualName, is(equalTo(expectedName)));
	}
	
	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
		final String name = "SystemTechnikLabor";
		String actualName = null;
		final String expectedName = "SystemTechnikLabor-if";
	    final Optional<String> underTest = Optional.of(name);
	    
	    underTest.ifPresent(myString -> actualName = myString + "-if";));
	    
	    assertThat(actualName, is(equalTo(expectedName)));
	}
	
	@Test
	public void whenOrElseWorks_thenCorrect() {
		final String nullName = null;
		final String expectedName = "htw saar";
	    String actualName = Optional.ofNullable(nullName).
	    		orElse(expectedName);
	    
	    assertThat(actualName, is(equalTo(expectedName)));
	}
	
	@Test
	public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
	    String text = null;
	 
	    System.out.println("orElseGet() benutzen:");
	    String defaultText = 
	      Optional.ofNullable(text).orElseGet(this::getMyDefault);
	    assertEquals("Default Value", defaultText);
	 
	    System.out.println("orElse benutzen():");
	    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
	    assertEquals("Default Value", defaultText);
	}
	
	@Test
	public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
	    String text = "Ein Text";
	 
	    System.out.println("orElseGet() benutzen:");
	    String defaultText 
	      = Optional.ofNullable(text).orElseGet(this::getMyDefault);
	    assertEquals("Ein Text", defaultText);
	 
	    System.out.println("orElse() benutzen:");
	    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
	    assertEquals("Ein Text", defaultText);
	}
	
	private String getMyDefault() {
	    System.out.println("Standardwert wird ermittelt");
	    return "Default Value";
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenOrElseThrowWorks_thenCorrect() {
	    final String nullName = null;
	    final String name = Optional.ofNullable(nullName).
	    orElseThrow(IllegalArgumentException::new);
	}
	
	@Test
	public void whenNoExceptionThrown_thenCorrect() {
	    final String name = "Ich bin nicht null";
	    final String actualName = Optional.ofNullable(name).
	    orElseThrow(IllegalArgumentException::new);
	    assertThat(actualName, is(equalTo(name)));
	}
	
	@Test
	public void givenOptional_whenGetsValue_thenCorrect() {
		final String expectedName = "SystemTechnikLabor";
	    final Optional<String> underTest = Optional.of("SystemTechnikLabor");
	    final String actualName = underTest.get();
	 
	    assertThat(actualName, is(equalTo(expectedName)));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
	    final Optional<String> underTest = Optional.ofNullable(null);
	    underTest.get();
	}
	
	@Test
	public void whenOptionalFilterWorks_thenCorrect() {
	    final Integer year = 2016;
	    final Optional<Integer> yearOptional = Optional.of(year);
	    final boolean is2016 = yearOptional.filter(y -> y == 2016).
	    	isPresent();
	    assertTrue(is2016);
	    final boolean is2017 = yearOptional.filter(y -> y == 2017).
	    	isPresent();
	    assertFalse(is2017);
	}
	
	@Test
	public void whenFiltersWithoutOptional_thenCorrect() {
	    assertTrue(priceIsInRange1(new Computer(1000.0)));
	    assertFalse(priceIsInRange1(new Computer(999.9)));
	    assertFalse(priceIsInRange1(new Computer(null)));
	    assertFalse(priceIsInRange1(new Computer(1500.5)));
	    assertFalse(priceIsInRange1(null));
	}
	
	@Test
	public void whenFiltersWithOptional_thenCorrect() {
	    assertTrue(priceIsInRange2(new Computer(1000.0)));
	    assertFalse(priceIsInRange2(new Computer(999.9)));
	    assertFalse(priceIsInRange2(new Computer(null)));
	    assertFalse(priceIsInRange2(new Computer(1500.5)));
	    assertFalse(priceIsInRange2(null));
	}
	
	@Test
	public void givenOptional_whenMapWorks_thenCorrect() {
	    final List<String> companyNames = Arrays.asList(
	      "paypal", "oracle", "", "microsoft", "", "apple");
	    Optional<List<String>> listOptional = Optional.of(companyNames);
	 
	    final int size = listOptional
	      .map(List::size)
	      .orElse(0);
	    assertEquals(6, size);
	}
	
	@Test
	public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
	    final String password = " password ";
	    final Optional<String> underTest = Optional.of(password);
	    boolean correctPassword = underTest.filter(
	      pass -> pass.equals("password")).isPresent();
	    assertFalse(correctPassword);
	 
	    correctPassword = underTest
	      .map(String::trim)
	      .filter(pass -> pass.equals("password"))
	      .isPresent();
	    assertTrue(correctPassword);
	}
	
	@Test
	public void givenOptional_whenFlatMapWorks_thenCorrect() {
	    final Person person = new Person("john", 26);
	    final Optional<Person> personOptional = Optional.of(person);
	 
	    final Optional<Optional<String>> nameOptionalWrapper  
	      = personOptional.map(Person::getName);
	    final Optional<String> nameOptional  
	      = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
	    final String name1 = nameOptional.orElse("");
	    assertEquals("john", name1);
	 
	    final String name = personOptional
	      .flatMap(Person::getName)
	      .orElse("");
	    assertEquals("john", name);
	}
	
	@Test
	public void testOptionalInt_empty() {
		final OptionalInt emptyOptionalInt = 
				OptionalInt.empty();
		assertTrue(emptyOptionalInt.isEmpty());
	}
	
	@Test
	public void testOptionalInt_notEmpty() {
		final OptionalInt optionalInt = 
				OptionalInt.of(44);
		assertFalse(optionalInt.isEmpty());
		assertEquals(44, optionalInt.getAsInt());
	}
}


