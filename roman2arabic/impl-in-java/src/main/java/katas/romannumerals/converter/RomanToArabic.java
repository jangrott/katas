package katas.romannumerals.converter;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import katas.romannumerals.ArabicNumeral;
import katas.romannumerals.RomanNumeral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf;

public class RomanToArabic extends Converter<RomanNumeral, ArabicNumeral> {

    public static final String PATTERN = "(?<=(.))(?!\\1)";

    private List<Integer> weightsOfSplittedParts;

    @Override
    protected ArabicNumeral doForward(RomanNumeral roman) {
        String[] groupedRomanByRepeatedChars = splitIntoRepeatedChars(roman);
        createWeightOfSplittedPartsAndReverseOrder(groupedRomanByRepeatedChars);

        while (weightsOfSplittedPartsHasMoreThanOneElement()) {
            mergeWeightsWithAdditionIfFirstIsLessThanOrEqualToSecond();
            mergeWeightsWithSubtractionIfFirstIsGreaterThanSecond();
            removeFirstWeightOfSplittedParts();
        }

        Integer arabicValue = weightsOfSplittedParts.get(0);

        return arabicNumeralOf(arabicValue);
    }

    private String[] splitIntoRepeatedChars(RomanNumeral roman) {
        return roman.split(PATTERN);
    }

    private void createWeightOfSplittedPartsAndReverseOrder(String[] splittedRoman) {
        weightsOfSplittedParts = new ArrayList<>();

        int lengthOfPart, weightOfGroup;
        char roman;

        for (String group : splittedRoman) {
            roman = group.charAt(0);
            lengthOfPart = group.length();
            weightOfGroup = getWeightForSingle(roman) * lengthOfPart;

            weightsOfSplittedParts.add(weightOfGroup);
        }

        weightsOfSplittedParts = Lists.reverse(weightsOfSplittedParts);
    }

    private boolean weightsOfSplittedPartsHasMoreThanOneElement() {
        return weightsOfSplittedParts.size() > 1;
    }

    private Integer getWeightForSingle(Character roman) {
        return BasicMapping.weightOf(roman);
    }

    private void mergeWeightsWithAdditionIfFirstIsLessThanOrEqualToSecond() {
        if (firstWeightIsLessThanOrEqualToSecond()) {
            mergeFirstAndSecondWeightWithAddition();
        }
    }

    private void mergeWeightsWithSubtractionIfFirstIsGreaterThanSecond() {
        if (firstWeightIsGreaterThanSecond()) {
            mergeFirstAndSecondWeightWithSubtraction();
        }
    }

    private boolean firstWeightIsLessThanOrEqualToSecond() {
        return weightsOfSplittedParts.get(0) <= weightsOfSplittedParts.get(1);
    }

    private boolean firstWeightIsGreaterThanSecond() {
        return weightsOfSplittedParts.get(0) > weightsOfSplittedParts.get(1);
    }

    private void mergeFirstAndSecondWeightWithSubtraction() {
        int value = weightsOfSplittedParts.get(0) - weightsOfSplittedParts.get(1);

        updateSecondElementWith(value);
    }

    private void mergeFirstAndSecondWeightWithAddition() {
        int value = weightsOfSplittedParts.get(0) + weightsOfSplittedParts.get(1);

        updateSecondElementWith(value);
    }

    private void updateSecondElementWith(Integer value) {
        weightsOfSplittedParts.set(1, value);
    }

    private void removeFirstWeightOfSplittedParts() {
        weightsOfSplittedParts.remove(0);
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