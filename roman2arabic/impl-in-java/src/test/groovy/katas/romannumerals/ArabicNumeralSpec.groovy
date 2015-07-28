package katas.romannumerals

import spock.lang.Specification
import spock.lang.Unroll

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf

@Unroll
class ArabicNumeralSpec extends Specification {

    def "The two arabic numerals with the same value should be equal"() {
        expect:
        arabicNumeralOf(1) == arabicNumeralOf(1)
    }

    def "The two arabic numerals with different value should not be equal"() {
        expect:
        arabicNumeralOf(1) != arabicNumeralOf(2)
    }
}
