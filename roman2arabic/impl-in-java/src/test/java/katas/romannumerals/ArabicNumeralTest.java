package katas.romannumerals;

import org.junit.Test;

public class ArabicNumeralTest {

    @Test(expected = NullPointerException.class)
    public void exceptionShouldBeThrownWhenNullPassed() {
        new ArabicNumeral(null);
    }
}