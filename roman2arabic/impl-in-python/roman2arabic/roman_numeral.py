import re

from roman2arabic.arabic_numeral import ArabicNumeral

class RomanNumeral:

    VALIDATION = '^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$'

    def __init__(self, value):
        self.checkValue(value)

        self.value = value

    def checkValue(self, value):
        if not value or not re.search(self.VALIDATION, value):
            raise ValueError("Wrong value!")

    def to_arabic(self):
        groups = self.split_value_into_groups_of_same_chars()[::-1]

        arabic_value = reduce(
            lambda st, nd: st + nd if st <= nd else st - nd,
            map(lambda group: self.basic_roman_value()[group[0]] * len(group), groups)
        )
        return ArabicNumeral(arabic_value)

    def split_value_into_groups_of_same_chars(self):
        return [m.group(0) for m in re.finditer(r"(\w)\1*", self.value)]

    def basic_roman_value(self):
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
