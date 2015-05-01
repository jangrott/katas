package katas.romannumerals;

import org.junit.Test;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;
import static org.assertj.core.api.Assertions.assertThat;

public class ArabicNumeralTest {

    @Test
    public void withTheSameValueShouldBeEqual() {
        assertThat(arabicNumeralOf(1)).isEqualTo(arabicNumeralOf(1));
    }
}