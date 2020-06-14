class Solution {
    public int climbStairs(int n) {
        if (n < 4) return n;
        int pre = 2;
        int curr = 3;
        int i = 4;
        while (i <= n) {
            int temp = curr;
            curr = pre + curr;
            pre = temp;
            i++;
        }
        return curr;
    }
}