import re

from roman2arabic.arabic_numeral import ArabicNumeral


class RomanNumeral:
    ROMAN_NUMERAL_VALIDATION_PATTERN = \
        '^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$'

    PATTERN_FOR_GROUPING_REPEATED_CHARS = r'(\w)\1*'

    def __init__(self, value):
        self.check_value(value)

        self.value = value

    def check_value(self, value):
        if not value or not re.search(self.ROMAN_NUMERAL_VALIDATION_PATTERN, value):
            raise ValueError("Wrong value!")

    def to_arabic(self):
        groups = self.split_value_into_groups_of_same_chars()[::-1]

        return ArabicNumeral(
            reduce(
                self.to_arabic_value,
                map(self.of_arabic_values_for_groups, groups)
            )
        )

    def split_value_into_groups_of_same_chars(self):
        return [m.group(0) for m in re.finditer(self.PATTERN_FOR_GROUPING_REPEATED_CHARS, self.value)]

    @staticmethod
    def to_arabic_value(acc, cur):
        return acc + cur if acc <= cur else acc - cur

    def of_arabic_values_for_groups(self, group):
        return self.basic_roman_values()[self.char_of(group)] * len(group)

    @staticmethod
    def char_of(s):
        return s[0]

    @staticmethod
    def basic_roman_values():
        numerals = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        return numerals