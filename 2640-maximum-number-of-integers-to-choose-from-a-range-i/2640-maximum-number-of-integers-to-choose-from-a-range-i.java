class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int num: banned){
            set.add(num);
        }

        int sum = 0;
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if (sum + i > maxSum) {
                break;
            }
            if(!set.contains(i) && sum + i <= maxSum){
                sum += i;
                cnt++;
            }
        }

        return cnt;
    }
}