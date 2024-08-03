class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left++]);
            } else {
                list.add(nums[right++]);
            }
        }

        while (left <= mid) {
            list.add(nums[left++]);
        }

        while (right <= high) {
            list.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }
    }
}