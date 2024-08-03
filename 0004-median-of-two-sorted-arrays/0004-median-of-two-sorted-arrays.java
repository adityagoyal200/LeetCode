class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)){
            return 0.0;
        }
        if(nums1.length <= nums2.length){
            return binarySearch(nums1,nums2);
        } else {
            return binarySearch(nums2,nums1);
        }        
    }
    private double binarySearch(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1+n2;

        int low = 0;
        int left = (n1+n2+1)/2;
        int high = n1;

        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = left - mid1;

            int l1 = (mid1 -1 >= 0) ? arr1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 -1 >= 0) ? arr2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 0){
                    return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                } else {
                    return (double)Math.max(l1,l2);
                }
            } else if(l1 > r2){
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }

        return 0.0;
    }
}