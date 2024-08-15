class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }

        int fiveCount = 0;
        int tenCount = 0;

        for (int num : bills) {
            if (num == 5) {
                fiveCount++;
            } else if (num == 10) {
                if (fiveCount >= 1) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else { 
                if (tenCount >= 1 && fiveCount >= 1) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
