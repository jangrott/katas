package katas.romannumerals.converter;

import katas.romannumerals.ArabicNumeral;
import katas.romannumerals.RomanNumeral;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;
import static katas.romannumerals.RomanNumeral.romanNumeralOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class RomanToArabicTest {
    private RomanToArabic arabicNumeralConverter;

    private RomanNumeral input;
    private ArabicNumeral output;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {romanNumeralOf("I"), arabicNumeralOf(1)},
                {romanNumeralOf("V"), arabicNumeralOf(5)},
                {romanNumeralOf("X"), arabicNumeralOf(10)},
                {romanNumeralOf("L"), arabicNumeralOf(50)},
                {romanNumeralOf("C"), arabicNumeralOf(100)},
                {romanNumeralOf("D"), arabicNumeralOf(500)},
                {romanNumeralOf("M"), arabicNumeralOf(1000)},
                {romanNumeralOf("IV"), arabicNumeralOf(4)},
                {romanNumeralOf("VI"), arabicNumeralOf(6)},
                {romanNumeralOf("VII"), arabicNumeralOf(7)},
                {romanNumeralOf("VIII"), arabicNumeralOf(8)},
                {romanNumeralOf("IX"), arabicNumeralOf(9)},
                {romanNumeralOf("XXVII"), arabicNumeralOf(27)},
                {romanNumeralOf("CCCXXV"), arabicNumeralOf(325)},
                {romanNumeralOf("CDXXXII"), arabicNumeralOf(432)},
                {romanNumeralOf("DCCCXLV"), arabicNumeralOf(845)},
                {romanNumeralOf("MCMXLIV"), arabicNumeralOf(1944)},
                {romanNumeralOf("MCMXLVII"), arabicNumeralOf(1947)},
                {romanNumeralOf("MCMXLVIII"), arabicNumeralOf(1948)},
                {romanNumeralOf("MM"), arabicNumeralOf(2000)},
                {romanNumeralOf("MMDCCCXIX"), arabicNumeralOf(2819)},
                {romanNumeralOf("MMDCCCXVIII"), arabicNumeralOf(2818)},
                {romanNumeralOf("MMMDXLIX"), arabicNumeralOf(3549)}
        });
    }

    @Before
    public void setUp() {
        arabicNumeralConverter = new RomanToArabic();
    }

    public RomanToArabicTest(RomanNumeral romanNumeral, ArabicNumeral arabicNumeral) {
        input = romanNumeral;
        output = arabicNumeral;
    }

    @Test
    public void canConvert() {
        assertThat(arabicNumeralConverter.convert(input)).isEqualTo(output);
    }
}