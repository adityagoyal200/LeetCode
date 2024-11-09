class Solution {
        public long minEnd(int n, int x) {
        long val = x;

        while (--n > 0){
            val = (val + 1) | x;
        }

        return val;
    }
}