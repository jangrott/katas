package katas.romannumerals;

import org.junit.Test;

import static katas.romannumerals.RomanNumeral.romanNumeralOf;

public class RomanNumeralTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionShouldBeThrownWhenNullPassed() {
        romanNumeralOf(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionShouldBeThrownWhenEmptyValuePassed() {
        romanNumeralOf("");
    }
}