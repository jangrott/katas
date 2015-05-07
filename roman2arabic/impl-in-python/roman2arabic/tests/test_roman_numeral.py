import unittest

from nose.tools import assert_equal
from nose_parameterized import parameterized
from roman2arabic.roman_numeral import RomanNumeral
from roman2arabic.arabic_numeral import ArabicNumeral

class TestRomanNumeral(unittest.TestCase):

    def test_exception_should_be_raised_when_none_passed(self):
        with self.assertRaises(ValueError):
            RomanNumeral(None)

    @parameterized.expand([
        '', 'IIII', 'DD', 'LL', 'VV', 'IIV', 'IXIX', 'XXXXXX', 'MMMM'
    ])
    def test_exception_should_be_raised_when_incorrect_value_passed(self, a):
        with self.assertRaises(ValueError):
            RomanNumeral(a)

    @parameterized.expand([
        ('I', 1),
        ('V', 5),
        ('X', 10),
        ('L', 50),
        ('C', 100),
        ('D', 500),
        ('M', 1000),
    ])
    def test_basic_can_be_converted_to_arabic(self, a, b):
        assert_equal(RomanNumeral(a).to_arabic(), ArabicNumeral(b))

    @parameterized.expand([
        ('IV', 4),
        ('VI', 6),
        ('VII', 7),
        ('VIII', 8),
        ('IX', 9),
        ('XXVII', 27),
        ('CCCXXV', 325),
        ('CDXXXII', 432),
        ('DCCCXLV', 845),
        ('MCMXLIV', 1944),
        ('MCMXLVIII', 1948),
        ('MM', 2000),
        ('MMDCCCXIX', 2819),
        ('MMDCCCXVIII', 2818),
        ('MMMDXLIX', 3549),
    ])
    def test_complex_can_be_converted_to_arabic(self, a, b):
        assert_equal(RomanNumeral(a).to_arabic(), ArabicNumeral(b))
