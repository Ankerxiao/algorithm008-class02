class Solution {
    public int maxProfit(int[] prices) {
        int prev = 0;
        int currMax = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[currMax]) {
                if (i == prices.length - 1) {
                    return profit + prices[i] - prices[prev];
                } else {
                    currMax = i;
                    continue;
                }
            } else {
                profit = profit + prices[currMax] - prices[prev];
                prev = i;
                currMax = i;
            }
        }
        return profit;
    }
}