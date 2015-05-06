package katas.romannumerals.converter

import katas.romannumerals.ArabicNumeral
import katas.romannumerals.RomanNumeral
import spock.lang.Specification
import spock.lang.Unroll

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf
import static katas.romannumerals.RomanNumeral.romanNumeralOf

@Unroll
class RomanToArabicSpec extends Specification {

    def "The conversion of basic roman with value equal to #romanValue is #arabicValue"() {
        expect:
        romanNumeralOf(romanValue).to(arabic()) == arabicNumeralOf(arabicValue)
        where:
        romanValue || arabicValue
        "I"        || 1
        "V"        || 5
        "X"        || 10
        "L"        || 50
        "C"        || 100
        "D"        || 500
        "M"        || 1000
    }

    def "The conversion of complex roman with value equal to #romanValue is #arabicValue\""() {
        expect:
        romanNumeralOf(romanValue).to(arabic()) == arabicNumeralOf(arabicValue)
        where:
        romanValue    || arabicValue
        "IV"          || 4
        "VI"          || 6
        "VII"         || 7
        "VIII"        || 8
        "IX"          || 9
        "XXVII"       || 27
        "CCCXXV"      || 325
        "CDXXXII"     || 432
        "DCCCXLV"     || 845
        "MCMXLIV"     || 1944
        "MCMXLVII"    || 1947
        "MCMXLVIII"   || 1948
        "MM"          || 2000
        "MMDCCCXIX"   || 2819
        "MMDCCCXVIII" || 2818
        "MMMDXLIX"    || 3549
    }

    static Converter<RomanNumeral, ArabicNumeral> arabic() {
        return new RomanToArabic();
    }
}