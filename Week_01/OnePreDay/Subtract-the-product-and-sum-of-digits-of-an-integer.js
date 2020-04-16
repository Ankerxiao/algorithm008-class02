/**
 * @param {number} n
 * @return {number}
 */
var subtractProductAndSum = function(n) {
    let strN = String(n);
    let arr = [];
    let multipyNum = 1;
    let sumNum = 0;
    for (let i = 0; i < strN.length; i++) {
        arr.push(Number(strN.charAt(i)));
    }
    for (let i = 0; i < strN.length; i++) {
        multipyNum *= arr[i];
        sumNum += arr[i];
    }
    return multipyNum - sumNum;
};

console.log(subtractProductAndSum(4421));