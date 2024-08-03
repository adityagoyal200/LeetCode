class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null){
            return 0;
        }
        int good = 0;

        for(int i = 0; i < nums1.length; i++){
            for(int  j = 0; j < nums2.length ; j++){
                if(nums1[i] % (nums2[j] * k)  == 0){
                    good++;
                }
            }
        }

        return good;
    }
}