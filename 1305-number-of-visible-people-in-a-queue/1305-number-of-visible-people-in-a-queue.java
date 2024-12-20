class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack();
        int[] result = new int[heights.length];

        for (int i = heights.length-1; i >=0 ; i--){
            int cnt = 0;
            while(!st.isEmpty() && heights[st.peek()] < heights[i]){
                cnt++;
                st.pop();
            }

            result[i] = cnt + (!st.isEmpty() ? 1 : 0);
            st.push(i);
        }

        return result;
    }
}