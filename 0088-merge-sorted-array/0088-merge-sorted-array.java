class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums1 == null || nums2 == null){
            return;
        }

        int end = m+n-1;
        int left = m-1;
        int right = n-1;

        while(left >= 0 && right >= 0){
            if(nums1[left] > nums2[right]){
                nums1[end] = nums1[left];
                left--;
            } else {
                nums1[end] = nums2[right];
                right--;
            }
            end--;
        }

        while(right >= 0){
            nums1[end--] = nums2[right--];
        }
        
    }
}