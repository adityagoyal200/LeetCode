class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSub(nums,k) - countSub(nums,k-1);
    }
    private int countSub(int[] nums,int k){
        if(nums == null || nums.length == 0 || k < 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int cnt  = 0;
        int odd = 0;

        while(right < nums.length){
            if((nums[right] & 1) == 1){
                odd++;
            }

            if(odd > k){
                while(odd > k){
                    odd -= ((nums[left++] & 1) ==1) ? 1 : 0;
                }
            }

            cnt += (right-left+1);
            right++;
        }

        return cnt;
    }
}