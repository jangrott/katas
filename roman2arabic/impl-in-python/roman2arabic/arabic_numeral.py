class ArabicNumeral:

    def __init__(self, value):
        if value is None:
            raise ValueError("Value can not be none!")

        self.value = value

    def __eq__(self, other):
        return (isinstance(other, self.__class__)
            and self.__dict__ == other.__dict__)

    def __ne__(self, other):
        return not self.__eq__(other)
