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

        /* i = 0 , loops does not run, st = [(2,0)] (val,index)
            i= 1 , h[0] >= h[1] ? yes so index = pop() 0 and current i= 1 
            is nse for that index and as we are storing pse in stack so peek() would be pse for index 
            calculate area for h[index] => h[index] * (nse-pse-1);
            max of largest
            let loop run because nse would be same for next index to if it exits
            if loop exits
            then add that index;
         */
        /*
        there will still be some indexes because for them 
        nse does not exist so nse will be? the length and pse same 
        calculate for same till empty stack
         */
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