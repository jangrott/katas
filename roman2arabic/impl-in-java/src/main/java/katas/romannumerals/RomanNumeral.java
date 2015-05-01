package katas.romannumerals;

import com.google.common.base.Converter;
import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;

public final class RomanNumeral {
    private final String value;

    private RomanNumeral(String value) {
        checkArgument(!Strings.isNullOrEmpty(value), "Value can not be null or empty");

        this.value = value;
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
