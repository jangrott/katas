package katas.romannumerals

import spock.lang.Specification
import spock.lang.Unroll

import static katas.romannumerals.RomanNumeral.romanNumeralOf

@Unroll
class RomanNumeralSpec extends Specification{

    def "The creation of roman numeral with #value should throw IllegalArgumentException"() {
        when:
            romanNumeralOf(value)
        then:
            thrown IllegalArgumentException
        where:
            value << ["IIII", "DD", "LL", "VV", "IIV", "IXIX", "XXXXXX", "MMMM"]
    }
}
