/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let i = digits.length - 1;
    let tempCarryNum = 1;
    while (i >= 0) {
        digits[i] = digits[i] + tempCarryNum;
        if (digits[i] >= 10) {
            digits[i] = digits[i] % 10;
            tempCarryNum = 1;
        } else {
            tempCarryNum = 0
        }
        i--;
    }
    if (tempCarryNum == 1) {
        digits.unshift(1);
    }
    return digits;
};
console.log(plusOne([1,1,7,9]));