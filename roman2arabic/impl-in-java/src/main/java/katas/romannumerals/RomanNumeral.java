package katas.romannumerals;

import com.google.common.base.Converter;
import com.google.common.base.Strings;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;

public final class RomanNumeral {
    private final String value;

    private static final Pattern VALIDATION = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    private RomanNumeral(String value) {
        checkArgument(isCorrect(value), "Wrong value");

        this.value = value;
    }

    private boolean isCorrect(String value) {
        return !Strings.isNullOrEmpty(value) && VALIDATION.matcher(value).matches();
    }

    public static RomanNumeral romanNumeralOf(String value) {
        return new RomanNumeral(value);
    }

    public String[] split(String pattern) {
        return value.split(pattern);
    }

    public <B> B to(Converter<RomanNumeral, B> converter) {
        return converter.convert(this);
    }

}
