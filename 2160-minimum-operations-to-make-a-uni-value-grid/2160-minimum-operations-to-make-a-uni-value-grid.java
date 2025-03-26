class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        int base = grid[0][0];
        int[] values = new int[total];
        int index = 0;
        
        // Single pass: validate and collect values
        for (int[] row : grid) {
            for (int val : row) {
                if ((val - base) % x != 0) return -1;
                values[index++] = (val - base) / x; // Normalize values
            }
        }
        
        // Find median of normalized values
        int median = findKthSmallest(values, total / 2);
        
        // Calculate operations
        int operations = 0;
        for (int val : values) {
            operations += Math.abs(val - median);
        }
        
        return operations;
    }
    
    // Quickselect to find kth smallest element (average O(n) time)
    private int findKthSmallest(int[] nums, int k) {
        return quickselect(nums, k, 0, nums.length - 1);
    }
    
    private int quickselect(int[] nums, int k, int left, int right) {
        if (left == right) return nums[left];
        
        int pivotIndex = partition(nums, left, right);
        
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickselect(nums, k, left, pivotIndex - 1);
        } else {
            return quickselect(nums, k, pivotIndex + 1, right);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivotValue = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivotValue) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}