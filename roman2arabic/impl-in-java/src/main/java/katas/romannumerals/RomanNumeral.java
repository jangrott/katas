package katas.romannumerals;

import com.google.common.base.Strings;
import katas.romannumerals.converter.Converter;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;

public final class RomanNumeral {
    
    private final String value;

    private static final Pattern ROMAN_NUMERAL_VALIDATION =
            Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    private RomanNumeral(String value) {
        checkArgument(isValid(value), "Wrong value");

        this.value = value;
    }

    private boolean isValid(String value) {
        return !Strings.isNullOrEmpty(value) && ROMAN_NUMERAL_VALIDATION.matcher(value).matches();
    }

    public static RomanNumeral romanNumeralOf(String value) {
        return new RomanNumeral(value);
    }

    public String[] split(String pattern) {
        return value.split(pattern);
    }

    public <T> T to(Converter<RomanNumeral, T> converter) {
        return converter.convert(this);
    }
}
