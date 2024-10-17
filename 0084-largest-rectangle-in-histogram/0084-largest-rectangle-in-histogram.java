class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        int[] nse = new int[heights.length];
        int[] pse = new int[heights.length];

        nse = findNse(heights);
        pse = findPse(heights);

        int area = 0;

        for(int i = 0; i < heights.length; i++){
            int currArea = heights[i] * (nse[i] - pse[i]-1);
            area = Math.max(area,currArea);
        }
       

        return area;
    }
    private int[] findNse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];

        for(int i = arr.length-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = (st.isEmpty()) ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }
    private int[] findPse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            pse[i] = (st.isEmpty()) ? -1: st.peek();
            st.push(i);
        }

        return pse;
    }

}