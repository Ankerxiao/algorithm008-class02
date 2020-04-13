var moveZeroes = function(nums) {
    let i = 0;
    let index = 0;
    for (index; index < nums.length; index++) {
        if (nums[index] != 0) {
            if (index != i) {
                nums[i] = nums[index];
                nums[index] = 0;
            }
            i++;
        }
    }
    return nums;
};
console.log(moveZeroes([0,1,0,3,12]));