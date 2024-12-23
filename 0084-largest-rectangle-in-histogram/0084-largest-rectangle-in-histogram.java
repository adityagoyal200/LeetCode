class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int[] pse = findPse(heights);
        int[] nse = findNse(heights);
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++){
            int currArea = heights[i] * (nse[i] -pse[i]-1);
            largest = Math.max(currArea,largest);
        }

        return largest;
    }
    private int[] findPse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            result[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }
    private int[] findNse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];

        for(int i = arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            result[i] = (st.isEmpty()) ? arr.length : st.peek();
            st.push(i);
        }

        return result;
    }
}