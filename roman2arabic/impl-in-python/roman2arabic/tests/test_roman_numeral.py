import unittest

from roman2arabic.roman_numeral import RomanNumeral

class TestRomanNumeral(unittest.TestCase):

    def test_exception_should_be_raised_when_none_passed(self):
        with self.assertRaises(ValueError):
            RomanNumeral(None)
