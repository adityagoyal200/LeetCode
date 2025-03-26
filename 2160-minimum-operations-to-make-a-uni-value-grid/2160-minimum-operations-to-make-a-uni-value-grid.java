class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        int[] values = new int[total];
        int index = 0;
        int base = grid[0][0];

        for (int[] row : grid) {
            for (int val : row) {
                if ((val - base) % x != 0) {
                    return -1;
                }
                values[index++] = val;
            }
        }

        int median = quickselect(values, total / 2, 0, total - 1);
        

        int operations = 0;
        for (int val : values) {
            operations += Math.abs(val - median) / x;
        }
        
        return operations;
    }
    
    private int quickselect(int[] nums, int k, int left, int right) {
        if (left == right) return nums[left];
        
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left);
        pivotIndex = partition(nums, left, right, pivotIndex);
        
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickselect(nums, k, left, pivotIndex - 1);
        } else {
            return quickselect(nums, k, pivotIndex + 1, right);
        }
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        
        swap(nums, right, storeIndex);
        return storeIndex;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}