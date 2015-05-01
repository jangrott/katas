package katas.romannumerals.converter;

import org.junit.Test;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;

public class RomanToArabicTest {

    @Test(expected = UnsupportedOperationException.class)
    public void exceptionShouldBeThrownWhenDoBackwardCalled() {
        new RomanToArabic().doBackward(arabicNumeralOf(1));
    }
}