class Solution {
    public long subArrayRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        
        int[] nseIndex = findNse(nums);  
        int[] pseIndex = findPse(nums);  
        int[] ngeIndex = findNge(nums); 
        int[] pgeIndex = findPge(nums);  

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long totalSmallSubarrays = (long) (i - pseIndex[i]) * (nseIndex[i] - i);
            long totalLargeSubarrays = (long) (i - pgeIndex[i]) * (ngeIndex[i] - i);
            sum += (totalLargeSubarrays * nums[i] - totalSmallSubarrays * nums[i]);
        }

        return sum;
    }

    private int[] findNse(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? nums.length : st.peek();
            st.push(i);
        }
        return result;
    }

    private int[] findPse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    private int[] findNge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nge;
    }

    private int[] findPge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
}

