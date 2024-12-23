class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, h * (right - left));
            while (left < right && height[left] <= h) {
                left++;
            }
            while (left < right && height[right] <= h) {
                right--;
            }
        }

        return maxArea;
    }
}