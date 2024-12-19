class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            while (!st.isEmpty() && st.peek() > arr[i]) {
                max = Math.max(max, st.pop());
            }
            st.push(max);
        }

        return st.size();
    }
}
