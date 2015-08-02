package katas.romannumerals

import spock.lang.Specification
import spock.lang.Unroll

import static katas.romannumerals.RomanNumeral.romanNumeralOf

@Unroll
class RomanNumeralSpec extends Specification {

    def "The creation of roman numeral with value equal to null should throw IllegalArgumentException"() {
        when:
        romanNumeralOf(null)
        then:
        thrown IllegalArgumentException
    }

    def "The creation of roman numeral with empty value should throw IllegalArgumentException"() {
        when:
        romanNumeralOf("")
        then:
        thrown IllegalArgumentException
    }

    def "The creation of roman numeral with value equal to #value should throw IllegalArgumentException"() {
        when:
        romanNumeralOf(value)
        then:
        thrown IllegalArgumentException
        where:
        value << ["IIII", "DD", "LL", "VV", "IIV", "IXIX", "XXXXXX", "MMMM"]
    }
}
