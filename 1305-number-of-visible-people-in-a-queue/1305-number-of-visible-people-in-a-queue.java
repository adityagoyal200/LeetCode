class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack();

        for (int i = heights.length-1; i >=0 ; i--){
            int h = heights[i], count = 0;

            while(!st.isEmpty() && st.peek() < h){
                count++;
                st.pop();
            }

            heights[i] = count + (st.isEmpty() ? 0: 1);
            st.push(h);
        }
        return heights;
    }
}