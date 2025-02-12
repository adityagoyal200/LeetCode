class Solution {
    public int maximumSum(int[] nums) {
        int[] mp = new int[82];  
        int ans = -1;

        for (int num : nums) {
            int sumDigits = digitSum(num);

            if (mp[sumDigits] > 0)
                ans = Math.max(ans, num + mp[sumDigits]);

            mp[sumDigits] = Math.max(mp[sumDigits], num);
        }
        return ans;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
