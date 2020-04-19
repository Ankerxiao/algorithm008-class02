class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int len = nums.length;
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }
    }
}