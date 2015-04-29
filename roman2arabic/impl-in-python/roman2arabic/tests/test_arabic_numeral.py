import unittest

from roman2arabic import arabic_numeral

class TestArabicNumeral(unittest.TestCase):

    def test_exception_should_be_raised_when_none_passed(self):
        with self.assertRaises(ValueError):
            arabic_numeral.ArabicNumeral(None)
