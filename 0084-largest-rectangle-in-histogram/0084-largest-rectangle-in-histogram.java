class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int index = st.pop(); // this index nse for h[index] and pse would be peek
                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();
                int currArea = heights[index] * (nse - pse - 1);
                largest = Math.max(currArea, largest);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int index = st.pop();
            int nse = heights.length;
            int pse = (st.isEmpty()) ? -1 : st.peek();
            int area = heights[index] * (nse - pse - 1);
            largest = Math.max(area, largest);
        }

        return largest;
    }
}