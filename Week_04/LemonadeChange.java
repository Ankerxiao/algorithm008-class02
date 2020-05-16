class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills[0] != 5) return false;
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill: bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (fiveCount > 0 && tenCount > 0) {
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount > 2) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}