class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int total = 0;
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(maxLeft <= height[left]){
                    maxLeft = height[left];
                } else {
                    total += maxLeft - height[left];
                }
                left++;
            } else {
                if(maxRight <= height[right]){
                    maxRight = height[right];
                } else {
                    total += maxRight - height[right];
                }
                right--;
            }
        }

        return total;
    }
}