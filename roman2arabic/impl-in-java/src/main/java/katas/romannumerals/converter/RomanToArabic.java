package katas.romannumerals.converter;

import com.google.common.collect.Lists;
import katas.romannumerals.ArabicNumeral;
import katas.romannumerals.RomanNumeral;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;

public class RomanToArabic implements Converter<RomanNumeral, ArabicNumeral> {

    public static final String PATTERN_FOR_GROUPING_REPEATED_CHARS = "(?<=(.))(?!\\1)";

    @Override
    public ArabicNumeral convert(RomanNumeral roman) {
        int arabicValue = Lists
                .reverse(splitGroupsOfSameChars(roman))
                .stream()
                .map(valueOfGroup)
                .reduce(0, accumulate);

        return arabicNumeralOf(arabicValue);
    }

    private List<String> splitGroupsOfSameChars(RomanNumeral roman) {
        return Arrays.asList(roman.split(PATTERN_FOR_GROUPING_REPEATED_CHARS));
    }

    private Function<String, Integer> valueOfGroup = group -> BasicMapping.valueOf(singleCharOf(group)) * group.length();

    private char singleCharOf(String s) {
        return s.charAt(0);
    }

    private BinaryOperator<Integer> accumulate = (acc, cur) -> acc <= cur ? acc + cur : acc - cur;

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

        public static int valueOf(char numeral) {
            return numerals.get(numeral);
        }
    }
}