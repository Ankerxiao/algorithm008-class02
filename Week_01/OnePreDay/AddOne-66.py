class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        i = len(digits)
        addNum = 1
        while (i >= 0):
            digits[i] = digits[i] + addNum
            if (digits[i] >= 10):
                digits[i] = digits[i] % 10;
                tempCarryNum = 1
            else:
                tempCarryNum = 0
            i -= 1
        if addNum == 1:
            digits = [1] + digits
        return digits
        