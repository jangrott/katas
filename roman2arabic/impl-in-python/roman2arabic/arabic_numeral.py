class ArabicNumeral:

    def __init__(self, value):
        self.check_value(value)

        self.value = value

    @staticmethod
    def check_value(value):
        if value is None or not isinstance(value, int):
            raise ValueError("Wrong value")

    def __eq__(self, other):
        return (isinstance(other, self.__class__)
            and self.__dict__ == other.__dict__)

    def __ne__(self, other):
        return not self.__eq__(other)
