class RomanNumeral:

    def __init__(self, value):
        if value is None:
            raise ValueError("Value can not be none!")
            
        self.value = value
