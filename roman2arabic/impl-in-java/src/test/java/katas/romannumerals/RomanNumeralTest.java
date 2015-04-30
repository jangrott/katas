package katas.romannumerals;

import katas.romannumerals.converter.RomanToArabic;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionShouldBeThrownWhenNullPassed() {
        new RomanNumeral(null);
    }

    @Test
    public void canBeConvertToArabic() {
        assertThat(new RomanNumeral("VIII").to(new RomanToArabic())).isEqualTo(new ArabicNumeral(8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionShouldBeThrownWhenEmptyValuePassed() {
        new RomanNumeral("");
    }
}