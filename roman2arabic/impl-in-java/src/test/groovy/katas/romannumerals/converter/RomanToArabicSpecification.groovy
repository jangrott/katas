import com.google.common.base.Converter
import katas.romannumerals.ArabicNumeral
import katas.romannumerals.RomanNumeral
import katas.romannumerals.converter.RomanToArabic
import spock.lang.Specification
import spock.lang.Unroll

import static katas.romannumerals.ArabicNumeral.arabicNumeralOf
import static katas.romannumerals.RomanNumeral.romanNumeralOf

@Unroll
class RomanToArabicSpecification extends Specification {

    def "The arabic conversion of #romanValue is #arabicValue"() {
        expect:
            romanNumeralOf(romanValue).to(arabic()) == arabicNumeralOf(arabicValue)
        where:
            romanValue      ||  arabicValue
            "I"             ||  1
            "V"             ||  5
            "X"             ||  10
            "L"             ||  50
            "C"             ||  100
            "D"             ||  500
            "M"             ||  1000
            "IV"            ||  4
            "VI"            ||  6
            "VII"           ||  7
            "VIII"          ||  8
            "IX"            ||  9
            "XXVII"         ||  27
            "CCCXXV"        ||  325
            "CDXXXII"       ||  432
            "DCCCXLV"       ||  845
            "MCMXLIV"       ||  1944
            "MCMXLVII"      ||  1947
            "MCMXLVIII"     ||  1948
            "MM"            ||  2000
            "MMDCCCXIX"     ||  2819
            "MMDCCCXVIII"   ||  2818
            "MMMDXLIX"      ||  3549
    }

    static Converter<RomanNumeral, ArabicNumeral> arabic() {
        return new RomanToArabic();
    }
}