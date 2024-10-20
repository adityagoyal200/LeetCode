class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        int largestRect = 0;
        //we compute pse while traversing and for nse when we pop for an element the element we pop for that index is nse for that popped out element
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int index = st.pop(); //  current index is nse for height[index]; and pse would be peek 
                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();
                int area = heights[index] * (nse-pse-1);
                largestRect = Math.max(area,largestRect);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int index = st.pop();
            int nse = heights.length;
            int pse = (st.isEmpty()) ? -1 : st.peek();
            int area = heights[index] * (nse-pse-1);
            largestRect = Math.max(area,largestRect);
        }

        return largestRect;       
    }
}