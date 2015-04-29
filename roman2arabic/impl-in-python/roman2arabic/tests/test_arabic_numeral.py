import unittest

from roman2arabic.arabic_numeral import ArabicNumeral

class TestArabicNumeral(unittest.TestCase):

    def test_exception_should_be_raised_when_none_passed(self):
        with self.assertRaises(ValueError):
            ArabicNumeral(None)
