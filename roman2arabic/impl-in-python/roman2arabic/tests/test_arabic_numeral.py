import unittest

from nose.tools import assert_equal, assert_not_equal
from roman2arabic.arabic_numeral import ArabicNumeral

class TestArabicNumeral(unittest.TestCase):

    def test_exception_should_be_raised_when_none_passed(self):
        with self.assertRaises(ValueError):
            ArabicNumeral(None)

    def test_with_the_same_value_should_be_equal(self):
        assert_equal(ArabicNumeral(1), ArabicNumeral(1))

    def test_with_different_value_should_not_be_equal(self):
        assert_not_equal(ArabicNumeral(1), ArabicNumeral(2))
