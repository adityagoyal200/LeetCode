class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        if (chalk == null || chalk.length == 0) {
            return -1;
        }

        long total = 0;

        for (int i = 0; i < chalk.length; i++) {
            total += chalk[i];
        }

        k %= total;

        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }

        return -1; 
    }
}
