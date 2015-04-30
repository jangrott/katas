package katas.romannumerals;

import com.google.common.base.Converter;
import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;

public class RomanNumeral {
    private final String value;

    public RomanNumeral(String value) {
        checkArgument(!Strings.isNullOrEmpty(value), "Value can not be null or empty");

        this.value = value;
    }

    public String value() {
        return value;
    }

    public <B> B to(Converter<RomanNumeral, B> converter) {
        return converter.convert(this);
    }

}
