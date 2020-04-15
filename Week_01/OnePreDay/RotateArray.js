/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    let index = nums.length - 1;
    for (let i = 0; i < k; i++) {
        nums.unshift(nums[index]);
        nums.pop();
    }
};
let nums = [1 ,2, 3, 4, 5, 6, 7, 8];
rotate(nums, 4);
console.log(nums);