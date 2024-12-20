class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            while (!st.isEmpty() && arr[i] < st.peek()) {
                max = Math.max(max, st.peek());
                st.pop();
            }

            st.push(max);
        }

        return st.size();
    }
}