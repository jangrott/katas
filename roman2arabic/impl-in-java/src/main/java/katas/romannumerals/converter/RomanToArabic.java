package katas.romannumerals.converter;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import katas.romannumerals.ArabicNumeral;
import katas.romannumerals.RomanNumeral;

import java.util.*;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;

public class RomanToArabic extends Converter<RomanNumeral, ArabicNumeral> {

    public static final String PATTERN = "(?<=(.))(?!\\1)";

    @Override
    protected ArabicNumeral doForward(RomanNumeral roman) {
        int arabicValue = Lists.reverse(splitGroupsOfSameChars(roman))
                .stream()
                .map((s) -> BasicMapping.weightOf(s.charAt(0)) * s.length())
                .reduce(
                        0, (first, second) -> first <= second ? first + second : first - second
                );

        return arabicNumeralOf(arabicValue);
    }

    private List<String> splitGroupsOfSameChars(RomanNumeral roman) {
        return Arrays.asList(roman.split(PATTERN));
    }

    @Override
    protected RomanNumeral doBackward(ArabicNumeral arabicNumeral) {
        throw new UnsupportedOperationException("Not supported yet!");
    }

    static class BasicMapping {
        private static final Map<Character, Integer> numerals = new HashMap<>();

        static {
            numerals.put('I', 1);
            numerals.put('V', 5);
            numerals.put('X', 10);
            numerals.put('L', 50);
            numerals.put('C', 100);
            numerals.put('D', 500);
            numerals.put('M', 1000);
        }

        public static Integer weightOf(char numeral) {
            return numerals.get(numeral);
        }
    }
}