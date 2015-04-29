import unittest

from roman2arabic import roman_numeral

class TestRomanNumeral(unittest.TestCase):

    def test_exception_should_be_raised_when_none_passed(self):
        with self.assertRaises(ValueError):
            roman_numeral.RomanNumeral(None)
