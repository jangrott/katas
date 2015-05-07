package katas.romannumerals.converter;

import com.google.common.collect.Lists;
import katas.romannumerals.ArabicNumeral;
import katas.romannumerals.RomanNumeral;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;

public class RomanToArabic implements Converter<RomanNumeral, ArabicNumeral> {

    public static final String PATTERN_FOR_GROUPING_REPEATED_CHARS = "(?<=(.))(?!\\1)";

    @Override
    public ArabicNumeral convert(RomanNumeral roman) {
        Optional<Integer> arabicValue = Lists
                .reverse(splitGroupsOfSameChars(roman))
                .stream()
                .map(groupToArabicValue)
                .reduce(toArabicValue);

        return arabicNumeralOf(arabicValue.get());
    }

    private List<String> splitGroupsOfSameChars(RomanNumeral roman) {
        return Arrays.asList(roman.split(PATTERN_FOR_GROUPING_REPEATED_CHARS));
    }

    private Function<String, Integer> groupToArabicValue =
            group -> BasicMapping.valueOf(singleCharOf(group)) * group.length();

    private char singleCharOf(String s) {
        return s.charAt(0);
    }

    private BinaryOperator<Integer> toArabicValue = (acc, cur) -> acc <= cur ? acc + cur : acc - cur;

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