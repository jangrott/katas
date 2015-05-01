package katas.romannumerals;

import katas.romannumerals.converter.RomanToArabic;
import org.junit.Test;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;
import static katas.romannumerals.RomanNumeral.romanNumeralOf;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionShouldBeThrownWhenNullPassed() {
        romanNumeralOf(null);
    }

    @Test
    public void canBeConvertToArabic() {
        assertThat(romanNumeralOf("VIII").to(new RomanToArabic())).isEqualTo(arabicNumeralOf(8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionShouldBeThrownWhenEmptyValuePassed() {
        romanNumeralOf("");
    }
}