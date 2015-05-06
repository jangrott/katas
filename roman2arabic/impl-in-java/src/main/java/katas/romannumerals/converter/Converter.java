package katas.romannumerals.converter;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
