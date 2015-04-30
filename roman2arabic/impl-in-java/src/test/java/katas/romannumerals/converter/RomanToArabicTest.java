package katas.romannumerals.converter;

import katas.romannumerals.ArabicNumeral;
import katas.romannumerals.RomanNumeral;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class RomanToArabicTest {
    private RomanToArabic arabicNumeralConverter;

    private RomanNumeral input;
    private ArabicNumeral output;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new RomanNumeral("I"), new ArabicNumeral(1)},
                {new RomanNumeral("V"), new ArabicNumeral(5)},
                {new RomanNumeral("X"), new ArabicNumeral(10)},
                {new RomanNumeral("L"), new ArabicNumeral(50)},
                {new RomanNumeral("C"), new ArabicNumeral(100)},
                {new RomanNumeral("D"), new ArabicNumeral(500)},
                {new RomanNumeral("M"), new ArabicNumeral(1000)},
                {new RomanNumeral("IV"), new ArabicNumeral(4)},
                {new RomanNumeral("VI"), new ArabicNumeral(6)},
                {new RomanNumeral("VII"), new ArabicNumeral(7)},
                {new RomanNumeral("VIII"), new ArabicNumeral(8)},
                {new RomanNumeral("IX"), new ArabicNumeral(9)},
                {new RomanNumeral("XXVII"), new ArabicNumeral(27)},
                {new RomanNumeral("CCCXXV"), new ArabicNumeral(325)},
                {new RomanNumeral("CDXXXII"), new ArabicNumeral(432)},
                {new RomanNumeral("DCCCXLV"), new ArabicNumeral(845)},
                {new RomanNumeral("MCMXLIV"), new ArabicNumeral(1944)},
                {new RomanNumeral("MCMXLVII"), new ArabicNumeral(1947)},
                {new RomanNumeral("MCMXLVIII"), new ArabicNumeral(1948)},
                {new RomanNumeral("MMDCCCXIX"), new ArabicNumeral(2819)},
                {new RomanNumeral("MMDCCCXVIII"), new ArabicNumeral(2818)},
                {new RomanNumeral("MMMDXLIX"), new ArabicNumeral(3549)}
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