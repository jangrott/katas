package katas.romannumerals;

public final class ArabicNumeral {

    private final int value;

    private ArabicNumeral(int value) {
        this.value = value;
    }

    public static ArabicNumeral arabicNumeralOf(int value) {
        return new ArabicNumeral(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArabicNumeral that = (ArabicNumeral) o;

        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
