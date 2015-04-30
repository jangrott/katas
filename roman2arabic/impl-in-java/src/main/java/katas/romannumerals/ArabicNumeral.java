package katas.romannumerals;

import static com.google.common.base.Preconditions.checkNotNull;

public class ArabicNumeral {

    private final Integer value;

    public ArabicNumeral(Integer value) {
        checkNotNull(value, "Value can not be null");

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArabicNumeral that = (ArabicNumeral) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
